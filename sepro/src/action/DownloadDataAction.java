package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import service.AppService;

public class DownloadDataAction extends BaseAction{

	private static final long serialVersionUID = 3532468906530303153L;
	
	private int questionnaireId;
	
	private InputStream fileInputStream;
	
	private String fileName;
	
	private AppService appService;

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	
	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String execute() throws Exception{
		fileName = "AnswerRecord.xls";
		String filePath = appService.getDataExcel(questionnaireId);
		File file = new File(filePath);
		try{
		fileInputStream = new FileInputStream(file);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
