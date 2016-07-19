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
		response.sendRedirect("/WebDemo/index.jsp");//作用同上
	
	}

	private void test8(HttpServletResponse response) {
		//缓存1小时
		response.setDateHeader("Expires", System.currentTimeMillis()+60*60*1000);
	}

	private void test7(HttpServletResponse response) throws IOException {
		//跳转到别的页面
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.setHeader("Refresh", "2;URL=/WebDemo/index.jsp");
		out.write("2秒后跳转");
	}

	private void test6(HttpServletResponse response) throws IOException {
//		跳转到自己
		Random r = new Random();
		int t = r.nextInt();
		response.setIntHeader("Refresh", 1);
		response.getOutputStream().write((t+"").getBytes());
	}

	private void test5(HttpServletResponse response) throws IOException {
		// 输出随机验证码图像
		int width = 30;
		int length = 120;

		// 创建一副内存图像 BufferedImage
		BufferedImage bi = new BufferedImage(length, width,
				BufferedImage.TYPE_INT_RGB);
		// 得到属于该图片的画笔
		Graphics g = bi.getGraphics();
		g.setColor(Color.GREEN);
		g.drawRect(0, 0, length, width);
		// 填充背景色
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, length - 2, width - 2);
		// 画干扰线

		Random r = new Random();
		g.setColor(Color.BLACK);
		for (int i = 1; i <= 10; i++) {
			g.drawLine(r.nextInt(length), r.nextInt(width), r.nextInt(length),
					r.nextInt(width));
		}
		// 随机数字
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD, 20));
		int x = 23;
		for (int i = 0; i < 4; i++) {

			g.drawString(r.nextInt(10) + "", x, 20);
			x += 20;
		}
		// 输出到浏览器上观看
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	private void test3(HttpServletResponse response) throws IOException {
		// 字符流输出中文字符
		String s = "蝴蝶大炮金箍棒!";

		// response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(s);
	}

	private void test2(HttpServletResponse response) throws IOException {
		// 字节流输出中文字符,utf-8输出
		String s = "幸福在哪里";
		ServletOutputStream out = response.getOutputStream();
		// response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=utf-8");
		out.write(s.getBytes("utf-8"));
	}

	private void test1(HttpServletResponse response) throws IOException {
		// 字节流输出中文字符
		String s = "哈哈";
		ServletOutputStream out = response.getOutputStream();
		out.write(s.getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
