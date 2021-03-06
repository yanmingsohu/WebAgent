// CatfoOD 2009-10-9 上午08:23:46

package jym.bt;

import java.io.DataOutputStream;
import java.io.IOException;

public class BTLinkService extends BTLink {
	private static int numid = 1;
	
	/**
	 * 建立一个蓝牙连接协议，连接成功后返回
	 * 
	 * @param uuid - 蓝牙服务唯一ID
	 * @throws IOException - 连接出错抛出异常
	 */
	public BTLinkService(String uuid) throws IOException {
		super(new BlueSevice(uuid));
	}

	protected void creatLink() throws IOException {
		DataOutputStream out = getOutStream();
		int id = numid++;
		out.writeInt(CREAT);
		out.writeInt(id);
		out.flush();
		creatAndSaveLogicLink(id);
	}

	public void newLink() throws IOException {
		throw new BlueToothException("不支持的方法");
	}
}
