package com.miot.smartconfig.smart;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

import android.util.Log;

public class SmartMulticast {
	private static final String TAG = MulticastSocket.class.getName();
	private MulticastSocket multicastSocket;// 组播
	private InetAddress address;

	/**
	 * 向服务端发�?广播
	 * 
	 * @param port
	 *            服务端端�?
	 * @param ip
	 *            服务端ip
	 * @param buffer
	 *            发�?的byte信息
	 * @param len
	 *            byte �?长度
	 */
	public void send(int port, String ip, byte[] buffer, int len) {
		Log.i(TAG, "send:" + ip + ":" + port + "[" + new String(buffer) + "]");
		try {

			address = InetAddress.getByName(ip);
			Log.e(TAG, "send:已找到服务器，正在连�?....");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			Log.e(TAG, "send:未找到服务器，连接失�?....");
			e.printStackTrace();
			return;
		}

		try {
			multicastSocket = new MulticastSocket(port);
			multicastSocket.setTimeToLive(1);
			// sendSocket = new MulticastSocket(port);
			multicastSocket.joinGroup(address);
			DatagramPacket sendDatagramPacket = new DatagramPacket(buffer, len,
					address, port);
			multicastSocket.send(sendDatagramPacket);
			Log.e(TAG, "send: 消息发�?成功......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(TAG, "send: 消息发�?失败......");
			return;
		} finally {
			if (multicastSocket != null) {
				try {
					multicastSocket.leaveGroup(address);
					multicastSocket.close();
					address = null;
					multicastSocket = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
