 package cn.mlj;
 import java.io.*;
 import javax.servlet.*;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.*;
 import java.awt.*;
 import java.awt.image.*;
 import javax.imageio.ImageIO;
 @WebServlet(urlPatterns = {"/CheckServlet"})
 public class CheckServlet extends HttpServlet
 {
 	private static int WIDTH = 80;
 	private static int HEIGHT = 20;
 public void doGet(HttpServletRequest request,HttpServletResponse response) 
 			throws ServletException,IOException{		
 		HttpSession session = request.getSession();
 		response.setContentType("image/jpeg");
 		ServletOutputStream sos = response.getOutputStream();
 		response.setHeader("Pragma","No-cache");
 		response.setHeader("Cache-Control","no-cache");
 		response.setDateHeader("Expires", 0);
 		BufferedImage image =
 			new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB); 
 		Graphics g = image.getGraphics();
 		char [] rands = generateCheckCode();
 		drawBackground(g);
 		drawRands(g,rands);
 		g.dispose();
 		ByteArrayOutputStream bos = new ByteArrayOutputStream();
 		ImageIO.write(image, "JPEG", bos);
 		byte [] buf = bos.toByteArray();
 		response.setContentLength(buf.length);
 		sos.write(buf);
 		bos.close();
 		sos.close();
 		session.setAttribute("check_code",new String(rands));
 	//request.getSession().setAttribute("check_code",new String(rands));
 	}
    private char [] generateCheckCode()
 	{
 		String chars = "0123456789abcdefghijklmnopqrstuvwxyz";
 		char [] rands = new char[5];
 		for(int i=0; i<5; i++)
 		{
 			int rand = (int)(Math.random() * 36);
 			rands[i] = chars.charAt(rand);
 		}
 		return rands;
 	}
 	private void drawRands(Graphics g , char [] rands)
 	{
 		g.setColor(Color.BLACK);
 		g.setFont(new Font(null,Font.ITALIC|Font.BOLD,18));
 		//鍦ㄤ笉鍚岀殑楂樺害涓婅緭鍑洪獙璇佺爜鐨勬瘡涓瓧绗�	
 		g.drawString("" + rands[0],1,17);
 		g.drawString("" + rands[1],16,15);
 		g.drawString("" + rands[2],31,18);
 		g.drawString("" + rands[3],46,16);
 		g.drawString("" + rands[4],61,19);
 		System.out.println(rands);
 	}
 	private void drawBackground(Graphics g)
 	{
 		g.setColor(new Color(0xDCDCDC));
 		g.fillRect(0, 0, WIDTH, HEIGHT);
 		for(int i=0; i<120; i++)
 		{
 			int x = (int)(Math.random() * WIDTH);
 			int y = (int)(Math.random() * HEIGHT);
 			int red = (int)(Math.random() * 255);
 			int green = (int)(Math.random() * 255);
 			int blue = (int)(Math.random() * 255);
 			g.setColor(new Color(red,green,blue));		
 			g.drawOval(x,y,1,0);
 		}
 	}
 }
