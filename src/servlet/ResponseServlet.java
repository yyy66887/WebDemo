package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setStatus(302);
//		response.setHeader("Location", "/WebDemo/index.jsp");
		response.sendRedirect("/WebDemo/index.jsp");//����ͬ��
	
	}

	private void test8(HttpServletResponse response) {
		//����1Сʱ
		response.setDateHeader("Expires", System.currentTimeMillis()+60*60*1000);
	}

	private void test7(HttpServletResponse response) throws IOException {
		//��ת�����ҳ��
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Refresh", "2;URL=/WebDemo/index.jsp");
		out.write("2�����ת");
	}

	private void test6(HttpServletResponse response) throws IOException {
//		��ת���Լ�
		Random r = new Random();
		int t = r.nextInt();
		response.setIntHeader("Refresh", 1);
		response.getOutputStream().write((t+"").getBytes());
	}

	private void test5(HttpServletResponse response) throws IOException {
		// ��������֤��ͼ��
		int width = 30;
		int length = 120;

		// ����һ���ڴ�ͼ�� BufferedImage
		BufferedImage bi = new BufferedImage(length, width,
				BufferedImage.TYPE_INT_RGB);
		// �õ����ڸ�ͼƬ�Ļ���
		Graphics g = bi.getGraphics();
		g.setColor(Color.GREEN);
		g.drawRect(0, 0, length, width);
		// ��䱳��ɫ
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, length - 2, width - 2);
		// ��������

		Random r = new Random();
		g.setColor(Color.BLACK);
		for (int i = 1; i <= 10; i++) {
			g.drawLine(r.nextInt(length), r.nextInt(width), r.nextInt(length),
					r.nextInt(width));
		}
		// �������
		g.setColor(Color.RED);
		g.setFont(new Font("����", Font.BOLD, 20));
		int x = 23;
		for (int i = 0; i < 4; i++) {

			g.drawString(r.nextInt(10) + "", x, 20);
			x += 20;
		}
		// �����������Ϲۿ�
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	private void test3(HttpServletResponse response) throws IOException {
		// �ַ�����������ַ�
		String s = "�������ڽ𹿰�!";

		// response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(s);
	}

	private void test2(HttpServletResponse response) throws IOException {
		// �ֽ�����������ַ�,utf-8���
		String s = "�Ҹ�������";
		ServletOutputStream out = response.getOutputStream();
		// response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=utf-8");
		out.write(s.getBytes("utf-8"));
	}

	private void test1(HttpServletResponse response) throws IOException {
		// �ֽ�����������ַ�
		String s = "����";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
