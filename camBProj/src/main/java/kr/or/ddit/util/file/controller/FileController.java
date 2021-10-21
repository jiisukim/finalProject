package kr.or.ddit.util.file.controller;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import kr.or.ddit.util.file.service.FileService;
import kr.or.ddit.util.file.vo.AttachFileGroupVO;
import kr.or.ddit.util.file.vo.AttachFileVO;

/**
 * 09/17 
 * - (파일 다운로드 제외) 컨트롤러 단에 util을 만들어 놓은 게 실수 : 다른 컨트롤러에서 사용할 수는 있는데, 서비스 단에서는 사용할 수 없음
 * - 서비스 단에 다시 util 메서드를 만들으니 서비스 단에 있는 메서드를 사용하면 됨
 * @author PC-08
 *
 */
@Controller
public class FileController {
	
	@Autowired
	FileService fileService;
	
	@Resource(name = "multipartResolver")
	CommonsMultipartResolver multipartResolver;
	
	/**
	 * 멀티 파일 리스트 파라미터를 받아
	 * 로컬 서버와 DB에 저장
	 * @param fileList
	 * @return 실패 시 'fail', 성공 시 fileGrNum 
	 */
	public String fileUpload(List<MultipartFile> fileList) {
		String uploadFolder = "Z:\\3team\\";  
//		String uploadFolder = "D:\\A_TeachingMaterial\\7.LastProject\\workspace\\camBProj\\src\\main\\webapp\\resources\\upload\\";
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
		
		int result = fileService.insert(attachFileGroupVo, attachFileVoList);
		
		String str = "fail"; 
		
		if(result > 0) {
			str = fileGrNum;
		}
			
		
		return str;
	}
	
	
	/**
	 * fileGrNum를 파라미터로 받아 
	 * 여러 개의 첨부파일이 담긴 List<AttachFileVO> 객체를 리턴
	 * @param fileGrNum
	 * @return List<AttachFileVO>
	 */
	public List<AttachFileVO> fileList(String fileGrNum) {
		List<AttachFileVO> fileList = fileService.fileList(fileGrNum);
		System.out.println(">> fileGrNum :  " + fileGrNum);
		System.out.println(">> fileList :  " + fileList);
		return fileList;
	}
	
	/**
	 * 파일 다운로드
	 * fileDownload?filePath=파일경로(AttachFileVO.getFilePath) url로 요청 시 다운로드 폴더에 파일 다운로드
	 * @param response
	 * @param filePath
	 * @param model
	 */
	@RequestMapping( "/fileDownload" )
	public void fileDownload( HttpServletResponse response, @RequestParam String filePath, Model model){
		try{
			File file = new File(filePath); // 파일명과 경로를 이용해서 File객체를 가져오기
	        String mimeType= URLConnection.guessContentTypeFromName(filePath);		//파일의 mime타입을 확인
	        if(mimeType==null){			// 마임타입이 없을 경우 application/octet-stream으로 설정 
	            mimeType = "application/octet-stream";
	        }
	        
	        String fileName = filePath.substring(filePath.indexOf("_")+1);
	        
	        response.setContentType(mimeType);	// reponse에 mimetype을 설정
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));		//--- Content-Disposition를 attachment로 설정하여 다운로드 받을 파일임을 브라우저에게 알려줌
	        response.setContentLength((int)file.length());		//--- response content length를 설정
	        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));	//--- inputstream 객체를 생성
	        FileCopyUtils.copy(inputStream, response.getOutputStream());		//--- inputstream으로 파일을 읽고 outputsream으로 파일을 다운로드
	        
		}catch( Exception e ){
			System.out.println(e.toString());
		}
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
//	@GetMapping("/getImgView.do")
//	public void getImgView(@ModelAttribute AttachFileVO paramVO, HttpServletResponse resp) throws IOException {
//		AttachFileVO atchFileVO = service.selectAtchFileBySn(paramVO);
//
//		File file = new File(atchFileVO.getStreCours(), atchFileVO.getStreFileNm());
//
//		byte[] bytes = FileUtils.readFileToByteArray(file);
//
//		resp.setHeader("Content-Disposition", "attachment; filename=\"" + atchFileVO.getOrignlFileNm() + "\";");
//
//		resp.setHeader("Content-Transfer-Encoding", "binary");
//
//		resp.getOutputStream().write(bytes);
//	}
	   
	   @GetMapping("/")
	   public void getFile(@RequestParam HashMap<String, Object> fileMap, HttpServletResponse resp) throws IOException {
		   AttachFileVO attachFileVo = fileService.selectImg(fileMap);
		   File file = new File(attachFileVo.getFilePath());
//		   File file = new File("C:\\upload\\trash.png");
//		   File file = new File("Z:\\3team\\2021\\10\\12\\4147e469-87fc-403b-8885-fb91c37c7784_camblogo.png");
		   byte[] bytes = FileUtils.readFileToByteArray(file);
		   resp.setHeader("Content-Disposition", "attachment; filename=\"" + attachFileVo.getOriginFileName() + "\";");
		   resp.setHeader("Content-Transfer-Encoding", "binary");
		   resp.getOutputStream().write(bytes);
	   }
	   
//	   @GetMapping("/display")
//	   @ResponseBody
//	   public ResponseEntity<byte[]> getFile(@RequestParam HashMap<String, Object> fileMap) {
//		   
//		   System.out.printf("fileMap", fileMap);
//		   
//		   AttachFileVO attachFileVo = fileService.selectImg(fileMap);
//		   
//		   File file = new File(attachFileVo.getFilePath());
//		   System.out.println(attachFileVo.getFilePath());
//		   
//		   ResponseEntity<byte[]> result = null;
//		   
//		   try {
//			   HttpHeaders header = new HttpHeaders();
//			   header.add("Content-Type", Files.probeContentType(file.toPath()));
//			   
//			   result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//			   
//		   }catch (IOException e) {
//			   System.out.printf("예외사항발생");
//			   e.printStackTrace();
//		   }
//		   System.out.println("File : " + file.toPath());
//		   System.out.println(result);
//		   return result;
//	   }
	
}
