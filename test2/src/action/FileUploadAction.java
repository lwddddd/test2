package action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class FileUploadAction extends ActionSupport {
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private static final int BUFFER_SIZE = 100 * 1024;

	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		
		return fileName.substring(pos);
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String execute() {
		UserDao ud = new UserDao();
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		User user = (User)session.get("user");		
		String  imageFileName = user.getAccount()+ getExtention(uploadFileName);
		File imageFile = new File(ServletActionContext.getServletContext()
				.getRealPath("UploadImages") + "/" + imageFileName);		
		copy(upload, imageFile);
		
//		System.out.println(imageFile.getPath());
		user.setPhoto("UploadImages\\" + imageFileName);
		ud.updateUser(user);
		return SUCCESS;
	}
}
