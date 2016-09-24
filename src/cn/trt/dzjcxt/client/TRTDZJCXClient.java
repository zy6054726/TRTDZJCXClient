package cn.trt.dzjcxt.client;

import javax.xml.rpc.ParameterMode;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class TRTDZJCXClient {
	private String url;

	/**
	 * 新建用户
	 * 
	 * @param uid
	 *            雇员编号 必填
	 * @param code
	 *            登录帐号 必填
	 * @param userName
	 *            用户姓名 必填
	 * @param post
	 *            岗位
	 * @param deptName
	 *            所属部门名称
	 * @param dnName
	 *            用户域唯一位置
	 * @return
	 */
	public String createUser(String uid, String code,String userName,String enabled,
			String post, String deptName, String dnName) {
		System.out.println("create >>uid:" + uid + "———code:" + code
				+ "——userName:" + userName + "——post:" + post + "——deptName:"
				+ deptName + "——dnName:" + dnName);
		// System.out.println("create》》》"+uid);
		System.setProperty("javax.net.ssl.trustStore", "/u01/app/oracle/jdk1.7.0_79/jre/lib/security/jssecacerts");
		String returnCode = "";
		Service service = new Service();
		int enableds = Integer.parseInt(enabled);
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("createUserInfo ");
			// 接口参数
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("code", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("userName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("enableds", XMLType.XSD_INT, ParameterMode.IN);
			call.addParameter("post", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("deptName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("dnName", XMLType.XSD_STRING, ParameterMode.IN);
			 System.out.println("create》》》接收参数");
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			returnCode = (String) call.invoke(new Object[] {uid, code,
					userName,enableds, post, deptName, dnName });
			System.out.println("create的返回参数：" + returnCode);
		} catch (Exception e) {
			throw new RuntimeException("创建异常：", e);
//			e.printStackTrace();
		}
		return returnCode;
	}

	/**
	 * 修改用户
	 * 
	 * @param uid
	 *            雇员编号 必填
	 * @param code
	 *            登录用户名 必填
	 * @param userName
	 *            显示用户名 必填
	 * @return
	 */
	public String modifyUser(String uid, String code, String userName,String enabled,
			String post, String deptName, String dnName) {
		System.out.println("modifyUser >>uid:" + uid + "———code:" + code
				+ "——userName:" + userName + "——post:" + post + "——deptName:"
				+ deptName + "——dnName:" + dnName);
		System.setProperty("javax.net.ssl.trustStore", "/u01/app/oracle/jdk1.7.0_79/jre/lib/security/jssecacerts");
		String returnCode = "";
		Service service = new Service();
		int enableds = Integer.parseInt(enabled);
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("editUserInfo");
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("code", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("userName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("enableds", XMLType.XSD_INT, ParameterMode.IN);
			call.addParameter("post", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("deptName", XMLType.XSD_STRING, ParameterMode.IN);
			call.addParameter("dnName", XMLType.XSD_STRING, ParameterMode.IN);
			System.out.println("modifyUser》 》 》接收参数...");
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			// 给方法传递参数，并且调用方法
			returnCode = (String) call.invoke(new Object[] { uid, code,
					userName,enableds, post, deptName, dnName });
			System.out.println("modify返回的参数：" + returnCode);
		} catch (Exception e) {
			throw new RuntimeException("修改异常：", e);
//			e.printStackTrace();
		}
		return returnCode;
	}

	/**
	 * 禁用 用户
	 * 
	 * @param uid
	 *            雇员编号  必填
	 * @return
	 */
	public String disableUser(String uid) {
		System.out.println("TRTDZJC disableUser request parm>>>>>uid:"
				+ uid);
		System.setProperty("javax.net.ssl.trustStore", "/u01/app/oracle/jdk1.7.0_79/jre/lib/security/jssecacerts");
		String returnCode = "";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("disableUserInfo");
			// 接口参数
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			System.out.println("disableUser》 》 》接收参数...");
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			// 给方法传递参数，并且调用方法
			returnCode = (String) call.invoke(new Object[] { uid });
			System.out.println("disable 返回参数》》" + returnCode);
		} catch (Exception e) {
			throw new RuntimeException("禁用异常：", e);
//			e.printStackTrace();
		}
		return returnCode;
	}

	/**
	 * 启用 用户
	 * 
	 * @param uid
	 *            雇员编号   必填
	 * @return
	 */
	public String enableUser(String uid) {
		System.out.println("TRTDZJC enableUser request parm>>>>>account:"
				+ uid);
		System.setProperty("javax.net.ssl.trustStore", "/u01/app/oracle/jdk1.7.0_79/jre/lib/security/jssecacerts");
		String returnCode = "";
		Service service = new Service();
		try {
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new java.net.URL(url));
			call.setOperationName("enableUserInfo");
			// 接口的参数
			System.out.println("enableUser》 》 》接收参数...");
			call.addParameter("uid", XMLType.XSD_STRING, ParameterMode.IN);
			// 设置返回类型
			call.setReturnType(XMLType.XSD_STRING);
			returnCode = (String) call.invoke(new Object[] { uid });
			System.out.println("enable返回参数》》》" + returnCode);
		} catch (Exception e) {
			throw new RuntimeException("启用异常：", e);
//			e.printStackTrace();
		}
		return returnCode;
	}

	public TRTDZJCXClient(String url) {

		this.url = url;
	}

	public TRTDZJCXClient() {
//		System.out.println("------构造方法---加载证书----");
		
		this.url = "https://epage.trtjk.com/services/userSynWebService.jws?wsdl";
//		System.out.println("----构造方法--证书加载完毕----");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static void main(String args[]) throws Exception {
//		System.setProperty("javax.net.ssl.trustStore", "E:\\computer\\jdk\\jkd1.7\\jre\\lib\\security\\jssecacerts");
		
//																	
		TRTDZJCXClient wc = new TRTDZJCXClient();
		System.out.println("执行方法");
		wc.createUser("1085812444", "idm03341", "张三4144","1", "", "第五区域222", "");
		wc.modifyUser("1085812444", "idm033", "张三323", "1", "", "", "");
		wc.disableUser("1085812444");
		wc.enableUser("1085812444");
		System.out.println("执行完毕");
	}

}
