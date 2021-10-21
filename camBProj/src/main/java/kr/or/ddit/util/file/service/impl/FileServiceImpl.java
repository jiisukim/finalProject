package kr.or.ddit.util.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.util.file.mapper.FileMapper;
import kr.or.ddit.util.file.service.FileService;
import kr.or.ddit.util.file.vo.AttachFileGroupVO;
import kr.or.ddit.util.file.vo.AttachFileVO;
	
@Service
public class FileServiceImpl implements FileService{

	@Autowired 
	FileMapper fileMapper;

	@Override
	public String fileUpload(List<MultipartFile> fileList) {
		String uploadFolder = "Z:\\3team\\"; 
//		String uploadFolder = "D:\\A_TeachingMaterial\\7.LastProject\\workspace\\camBProj\\src\\main\\webapp\\resources\\upload\\";
//		String uploadFolder = "/A_TeachingMaterial/7.LastProject/workspace/camBProj/src/main/webapp/resources/upload/"; // 리눅스 표기법
		
		File uploadPath = new File(uploadFolder, getFolder());
		
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs(); 
		}
		
		String fileGrNum = UUID.randomUUID().toString();
		
		// 세션 가져와서 회원 아이디 넣기
		String creator = "temp";
		
		AttachFileGroupVO attachFileGroupVo = new AttachFileGroupVO();
		attachFileGroupVo.setFileGrNum(fileGrNum);
		
		List<AttachFileVO> attachFileVoList = new ArrayList<>();
		
		int i = 1;
		for(MultipartFile file : fileList) {
			int fileGrSeq = i++;
			
			String originFileName = file.getOriginalFilename();
			
			String fileExtns = originFileName.substring(originFileName.lastIndexOf(".")+1);
			
			String saveFileName 	= file.getOriginalFilename();
			saveFileName			= saveFileName.substring(saveFileName.lastIndexOf("\\")+1);
			UUID uuid 				= UUID.randomUUID();
			saveFileName 			= uuid.toString() + "_" + saveFileName;
			
			String filePath = "Z:/3team/" + getFolder() + "/" + saveFileName;
			filePath = filePath.replace("\\", "/"); //웹 상 경로로 변경
			
			File savedFile = new File(uploadPath, saveFileName); 
			
			try {
				file.transferTo(savedFile);
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
			AttachFileVO attachFileVo = new AttachFileVO();
			attachFileVo.setFileGrNum(fileGrNum);
			attachFileVo.setFileGrSeq(fileGrSeq);
			attachFileVo.setOriginFileName(originFileName);
			attachFileVo.setSaveFileName(saveFileName);
			attachFileVo.setFilePath(filePath);
			attachFileVo.setFileExtns(fileExtns);
			attachFileVo.setCreator(creator);
			
			attachFileVoList.add(attachFileVo);
		}
		
		System.out.println("attachFileGroupVo : " + attachFileGroupVo.toString());
		System.out.println("attachFileVoList : " + attachFileVoList.toString());
		
		int result = insert(attachFileGroupVo, attachFileVoList);
		
		String str = "fail"; 
		
		if(result > 0) {
			str = fileGrNum;
		}
			
		
		return str;
	}

	@Override
	public List<AttachFileVO> fileList(String fileGrNum) {
		return fileMapper.fileList(fileGrNum);
	}
	
	@Override
	public int insert(AttachFileGroupVO attachFileGroupVo, List<AttachFileVO> attachFileVoList) {
		
		int result = fileMapper.insertFileGroup(attachFileGroupVo);
		
		if(result < 0) {
			return 0; // 실패 시 0 
		}

		for(AttachFileVO attachFileVo : attachFileVoList) {
			System.out.println("service >> attachFileVo" + attachFileVo);
			result = fileMapper.insertFile(attachFileVo);
			if(result < 0) { // 한 건이라도 실패 시 0
				return 0;
			}
		}
		
		return result;
	}
	
	/**
	 * 파일 업로드 [연도/월/일] 폴더 처리
	 * @return
	 */
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	@Override
	public AttachFileVO selectImg(HashMap<String, Object> fileMap) {
		return fileMapper.selectImg(fileMap);
	}
}
