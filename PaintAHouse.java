/* Input: 2 coordinates of a point. In order to quit, enter -1 as a coordinate
* Output: An html file with a drawn house, including the points by the given coordinates,
* which appear with two different colors (dep. on whether the point is inside/outside the house.
* External jars: batik.jar, batik-dom.jar, batik-svggen.jar 
*/


import java.awt.*;
import java.io.*;

import java.util.Scanner;

import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.svg.SVGDocument;

/**
 *
 * @author bas
 */

public class PaintAHouse {

	private static int[] dot = new int[2];
	private static boolean dotIsInside;

	public void paint(Graphics2D g2d) {

		// Assume this is already initialized
		g2d.setStroke(new BasicStroke(3));

		g2d.drawString("10", 55, 20);
		g2d.drawString("12.5", 115, 20);
		g2d.drawString("15", 195, 20);
		g2d.drawString("17.5", 255, 20);
		g2d.drawString("20", 335, 20);
		g2d.drawString("22.5", 395, 20);


		g2d.drawString("3.5" , 23, 70);
		g2d.drawString("6", 23, 140);
		g2d.drawString("8.5", 23, 210);
		g2d.drawString("11", 23, 280);
		g2d.drawString("13.5", 23, 350);
		g2d.drawString("16", 23, 420);
		

		int[] x = new int[] { 280, 420, 140 };
		int[] y = new int[] { 60, 200, 200 };
		int n = 3; // count of points

		g2d.setColor(Color.BLACK);
		// Make a triangle
		g2d.drawPolygon(x, y, n);
		g2d.drawRect(140, 200, 140, 140);
		g2d.drawRect(350, 200, 70, 140);
		g2d.setColor(Color.GRAY);
		g2d.fillPolygon(x, y, n);
		g2d.fillRect(140, 200, 140, 140);
		g2d.fillRect(350, 200, 70, 140);

		float dash1[] = { 1.0f };
		BasicStroke dashed = new BasicStroke(0.3f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f);
		g2d.setColor(Color.GRAY);
		g2d.setStroke(dashed);
		
		g2d.drawLine(53, 60, 440, 60);
		g2d.drawLine(53, 130, 440, 130);
		g2d.drawLine(53, 200, 440, 200);
		g2d.drawLine(53, 270, 440, 270);
		g2d.drawLine(53, 340, 440, 340);
		g2d.drawLine(53, 410, 440, 410);

		g2d.drawLine(70, 30, 70, 440);
		g2d.drawLine(140, 30, 140, 440);
		g2d.drawLine(210, 30, 210, 440);
		g2d.drawLine(280, 30, 280, 440);
		g2d.drawLine(350, 30, 350, 440);
		g2d.drawLine(420, 30, 420, 440);

		g2d.setStroke(new BasicStroke(3));
		setDot();
		while (dot[0] != -1) {
			
			if (dotIsInside) {
			g2d.setColor(Color.BLACK);
			} else {
				g2d.setColor(Color.GRAY);
			}
			g2d.drawOval((int) dot[0], (int) dot[1], 5, 5);
			setDot();
		}
	}

	public void setDot() {
		System.out.println("Dot:");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		if (x1 == -1) {
			dot[0] = -1;
		} else {
			double y1 = input.nextDouble();
			double x = 67.5 + (70 * ((x1 - 10) / 2.5));
			double y = 57.5 + (70 * ((y1 - 3.5) / 2.5));
			dotIsInside = isInside(x1, y1);
			dot[0] = (int) x;
			dot[1] = (int) y;
		}
	}

	public boolean isInside(double x, double y) {
		boolean isInside = false;

		if (((x >= 12.5 && x <= 17.5) || (x >= 20 && x <= 22.5))
				&& (y >= 8.5 && y <= 13.5)) {
			isInside = true;
		} else if ((x >= 12.5 && x <= 22.5) && (y >= 3.5 && y <= 8.5)
				&& (-x - y + 21 <= 0) && (x - y - 14 <= 0)) {
			isInside = true;
		} else {
			isInside = false;
		}

		return isInside;
	}

	public static void main(String[] args) throws IOException {

		// Get a DOMImplementation.
		DOMImplementation domImpl = SVGDOMImplementation.getDOMImplementation();

		// Create an instance of org.w3c.dom.Document.
		String svgNS = SVGDOMImplementation.SVG_NAMESPACE_URI;
		SVGDocument document = (SVGDocument) domImpl.createDocument(svgNS,
				"svg", null);

		// Create an instance of the SVG Generator.
		SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

		// Ask the test to render into the SVG Graphics2D implementation.
		PaintAHouse test = new PaintAHouse();
		test.paint(svgGenerator);

		// Finally, stream out SVG to the standard output using
		// UTF-8 encoding.
		boolean useCSS = true; // we want to use CSS style attributes
		OutputStream ostream = new FileOutputStream("out.html");
		Writer out = new OutputStreamWriter(ostream, "UTF-8");
		svgGenerator.stream(out, useCSS);

	}
 
}
