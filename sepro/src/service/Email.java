package service;
import java.util.Iterator;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Properties;  
  
import javax.activation.DataHandler;  
import javax.activation.FileDataSource;  
import javax.mail.BodyPart;  
import javax.mail.Message;  
import javax.mail.Multipart;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart;  
import javax.mail.internet.MimeMessage;  
import javax.mail.internet.MimeMultipart;  
import javax.mail.internet.MimeUtility;  
  
public class Email {  
    private static String defaultSenderName = "";// Ĭ�ϵķ������û�����defaultEntity�õõ�  
    private static String defaultSenderPass = "";// Ĭ�ϵķ��������룬defaultEntity�õõ�  
    private static String defaultSmtpHost = "";// Ĭ�ϵ��ʼ���������ַ��defaultEntity�õõ�  
  
    private String smtpHost; // �ʼ���������ַ  
    private String sendUserName; // �����˵��û���  
    private String sendUserPass; // ����������  
  
    private MimeMessage mimeMsg; // �ʼ�����  
    private Session session;  
    private Properties props;  
    private Multipart mp;// ������ӵ����  
    private List<FileDataSource> files = new LinkedList<FileDataSource>();// ��Ÿ����ļ�  
  
    private void init() {  
        if (props == null) {  
            props = System.getProperties();  
        }  
        props.put("mail.smtp.host", smtpHost);  
        props.put("mail.smtp.auth", "true"); // ��Ҫ�����֤  
        session = Session.getDefaultInstance(props, null);  
        // ��true�����ڿ���̨��console)�Ͽ��������ʼ��Ĺ���  
        session.setDebug(true);  
        // ��session��������������ʼ���ʼ�����  
        mimeMsg = new MimeMessage(session);  
        // ���ɸ��������ʵ��  
        mp = new MimeMultipart();  
    }  
  
    private Email(String smtpHost, String sendUserName, String sendUserPass, String to, String cc, String mailSubject, String mailBody,  
            List<String> attachments) {  
        this.smtpHost = smtpHost;  
        this.sendUserName = sendUserName;  
        this.sendUserPass = sendUserPass;  
  
        init();  
        setFrom(sendUserName);  
        setTo(to);  
        setCC(cc);  
        setBody(mailBody);  
        setSubject(mailSubject);  
        if (attachments != null) {  
            for (String attachment : attachments) {  
                addFileAffix(attachment);  
            }  
        }  
  
    }  
  
    /** 
     * �ʼ�ʵ�� 
     *  
     * @param smtpHost 
     *            �ʼ���������ַ 
     * @param sendUserName 
     *            �����ʼ���ַ 
     * @param sendUserPass 
     *            ������������ 
     * @param to 
     *            �ռ��ˣ���������ַ�԰�Ƕ��ŷָ� 
     * @param cc 
     *            ���ͣ���������ַ�԰�Ƕ��ŷָ� 
     * @param mailSubject 
     *            �ʼ����� 
     * @param mailBody 
     *            �ʼ����� 
     * @param attachmentPath 
     *            ����·�� 
     * @return 
     */  
    public static Email entity(String smtpHost, String sendUserName, String sendUserPass, String to, String cc, String mailSubject, String mailBody,  
            List<String> attachments) {  
        return new Email(smtpHost, sendUserName, sendUserPass, to, cc, mailSubject, mailBody, attachments);  
    }  
  
    /** 
     * Ĭ���ʼ�ʵ�壬����Ĭ�ϵķ����ʺź��ʼ������� 
     *  
     * @param to 
     *            �ռ��ˣ���������ַ�԰�Ƕ��ŷָ� 
     * @param cc 
     *            ���ͣ���������ַ�԰�Ƕ��ŷָ� 
     * @param subject 
     *            �ʼ����� 
     * @param body 
     *            �ʼ����� 
     * @param attachment 
     *            ����ȫ·�� 
     * @return 
     */  
    public static Email defaultEntity(String to, String cc, String subject, String body, List<String> attachments) {  
        return new Email(defaultSmtpHost, defaultSenderName, defaultSenderPass, to, cc, subject, body, attachments);  
    }  
  
    /** 
     * �����ʼ����� 
     *  
     * @param mailSubject 
     * @return 
     */  
    private boolean setSubject(String mailSubject) {  
        try {  
            mimeMsg.setSubject(mailSubject);  
        } catch (Exception e) {  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * �����ʼ�����,��������Ϊ�ı���ʽ��HTML�ļ���ʽ�����뷽ʽΪUTF-8 
     *  
     * @param mailBody 
     * @return 
     */  
    private boolean setBody(String mailBody) {  
        try {  
            BodyPart bp = new MimeBodyPart();  
            bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + mailBody, "text/html;charset=UTF-8");  
            // �����������ʼ��ı�  
            mp.addBodyPart(bp);  
        } catch (Exception e) {  
            System.err.println("�����ʼ�����ʱ��������" + e);  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * ���һ������ 
     *  
     * @param filename 
     *            �ʼ������ĵ�ַ��ֻ���Ǳ�����ַ�������������ַ�������׳��쳣 
     * @return 
     */  
    public boolean addFileAffix(String filename) {  
        try {  
            if (filename != null && filename.length() > 0) {  
                BodyPart bp = new MimeBodyPart();  
                FileDataSource fileds = new FileDataSource(filename);  
                bp.setDataHandler(new DataHandler(fileds));  
                bp.setFileName(MimeUtility.encodeText(fileds.getName(), "utf-8", null)); // ���������������  
                mp.addBodyPart(bp);// ��Ӹ���  
                files.add(fileds);  
            }  
        } catch (Exception e) {  
            System.err.println("�����ʼ�������" + filename + "��������" + e);  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * ɾ�����и��� 
     *  
     * @return 
     */  
    public boolean delFileAffix() {  
        try {  
            FileDataSource fileds = null;  
            for (Iterator<FileDataSource> it = files.iterator(); it.hasNext();) {  
                fileds = it.next();  
                if (fileds != null && fileds.getFile() != null) {  
                    fileds.getFile().delete();  
                }  
            }  
        } catch (Exception e) {  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * ���÷����˵�ַ 
     *  
     * @param from 
     *            �����˵�ַ 
     * @return 
     */  
    private boolean setFrom(String from) {  
        try {  
            mimeMsg.setFrom(new InternetAddress(from));  
        } catch (Exception e) {  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * �����ռ��˵�ַ 
     *  
     * @param to�ռ��˵ĵ�ַ 
     * @return 
     */  
    private boolean setTo(String to) {  
        if (to == null)  
            return false;  
        try {  
            mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));  
        } catch (Exception e) {  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * ���ó��� 
     *  
     * @param cc 
     * @return 
     */  
    private boolean setCC(String cc) {  
        if (cc == null) {  
            return false;  
        }  
        try {  
            mimeMsg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));  
        } catch (Exception e) {  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * �����ʼ� 
     *  
     * @return 
     */  
    public boolean send() throws Exception {  
        mimeMsg.setContent(mp);  
        mimeMsg.saveChanges();  
        System.out.println("���ڷ����ʼ�....");  
        Transport transport = session.getTransport("smtp");  
        // �����ʼ������������������֤  
        System.out.println("1");  
        transport.connect(smtpHost, sendUserName, sendUserPass);  
        // �����ʼ�  
        System.out.println("2");  
        transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));  
        System.out.println("�����ʼ��ɹ���");  
        transport.close();  
        return true;  
    }  
}