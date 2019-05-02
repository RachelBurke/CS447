
/**
 * Rachel Burke
 * January 24, 2019
 * Computer Graphics
 * Dr. Chen
 * 
 * Project 1: A Colorful House
 * In this program project, we will learn to use the methods in Graphics
 * and Color classes to write in a Java application program to draw a house.
 * The house should be painted. You are the designer of the house. So what
 * the house looks like and what colors you want to use to paint the house
 * are up to you. You need at least two functions from each of the Graphics
 * and Color classes. 
 */

/**
 * *************************************************************************
 * For this project, I chose to draw Toad's House from Super Mario. There is
 * a house, a tree, sun , clouds, and other objects drawn. Also, some code
 * has been formated so that when the screen resizes, the objects resize
 * accordingly, however some objects have yet to be completed. 
 * *************************************************************************
 */
import java.awt.*;
import java.awt.event.*;

/**
 * ProjHouse Object is a Window with a title and boarder given by Frame
 * component
 */
public class ProjHouse extends Frame {
    private static final long serialVersionUID = 1L;

    /**
     * Main Calls the ProjHouse window to open
     */
    public static void main(String[] args) {
        new ProjHouse();
    }

    /**
     * ProjHouse Opens a window that listens for events and adds a ToadHouse object
     * centered inside
     */
    ProjHouse() {
        // Window Header
        super("Project 1: House Project");

        // Window Listner
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(1350, 675);
        add("Center", new ToadHouse());
        setVisible(true);
    }
}

/**
 * ToadHouse implements the Canvas component to "paint" a picture of whatever
 * draw commands are inside
 */
class ToadHouse extends Canvas {
    private static final long serialVersionUID = 1L;

    /**
     * Paint the Sky
     */
    public void paintSky(Graphics2D g2, Dimension d) {
        // Fill
        g2.setPaint(new GradientPaint(0, 0, new Color(240, 110, 205), 0, d.height, new Color(240, 215, 35), true));
        g2.fillRect(0, 0, d.width, d.height);
    }

    /**
     * Paint the Sun
     */
    public void paintSun(Graphics g2, Dimension d) {
        // Outline
        g2.setColor(Color.BLACK);
        g2.drawOval((int) (d.width / 13.5) - 1, (int) (d.width / 27) - 1, (int) (d.width / 13.5) + 1,
                (int) (d.height / 6.75) + 1);
        // Fill
        g2.setColor(new Color(255, 95, 85));
        g2.fillOval((int) (d.width / 13.5), (int) (d.width / 27), (int) (d.width / 13.5), (int) (d.height / 6.75));
    }

    /**
     * Paint a cloud based on given arrays of x and y coordinates
     */
    public void paintClouds(Graphics2D g2, Dimension d, double cloudx[], double cloudy[]) {
        // Outline
        g2.setColor(Color.BLACK);
        for (int i = 0; i < cloudx.length; i++)
            g2.drawOval((int) (d.width / cloudx[i] - 1), (int) (d.width / cloudy[i] - 1), (int) (d.width / 27) + 1,
                    (int) (d.height / 13.5) + 1);
        // Fill
        g2.setColor(new Color(242, 242, 242));
        for (int i = 0; i < cloudx.length; i++)
            g2.fillOval((int) (d.width / cloudx[i]), (int) (d.width / cloudy[i]), (int) (d.width / 27),
                    (int) (d.height / 13.5));
    }

    /**
     * Paint a mountain given arrays of top circle, body rectangle, and eye
     * coordinates
     */
    public void paintMountain(Graphics2D g2, Dimension d, int mountainTop[], int mountainBod[], int mountainEyes[]) {
        // Outline
        g2.setColor(Color.BLACK);
        g2.drawOval(mountainTop[0] - 1, mountainTop[1] - 1, mountainTop[2] + 1, mountainTop[3] + 1);
        g2.drawRect(mountainBod[0] - 1, mountainBod[1], mountainBod[2] + 1, mountainBod[3]);

        // Fill Mountain
        g2.setPaint(new GradientPaint((int) d.width / 2, 0, new Color(25, 178, 73), (int) (2 * d.width) / 3, d.height,
                new Color(25, 102, 49), true));
        g2.fillOval(mountainTop[0], mountainTop[1], mountainTop[2], mountainTop[3]);
        g2.fillRect(mountainBod[0], mountainBod[1], mountainBod[2], mountainBod[3]);

        // Fill Eyes
        g2.setColor(Color.BLACK);
        g2.fillRect(mountainEyes[0], mountainEyes[2], mountainEyes[3], mountainEyes[4]);
        g2.fillRect(mountainEyes[1], mountainEyes[2], mountainEyes[3], mountainEyes[4]);
    }

    /**
     * Paint the Ground
     */
    public void paintGround(Graphics2D g2, Dimension d) {
        // Outline
        g2.setColor(Color.BLACK);
        g2.drawOval(-24, d.height - (int) (d.width / 13) - 1, (int) (d.width / 3) + 1, (int) (d.width / 6.75) + 1);
        g2.drawOval((int) (d.width / 6) - 1, d.height - (int) (d.width / 9) - 1, (int) (d.width / 1.5) + 1,
                (int) (d.width / 4.5) + 1);
        g2.drawOval((int) (d.width / 1.45) - 1, d.height - (int) (d.width / 13) - 1, (int) (d.width / 3) + 1,
                (int) (d.width / 6.75) + 1);
        // Fill
        g2.setColor(new Color(85, 240, 35, 250));
        g2.fillOval(-25, d.height - (int) (d.width / 13), (int) (d.width / 3), (int) (d.width / 6.75));
        g2.fillOval((int) (d.width / 6), d.height - (int) (d.width / 9), (int) (d.width / 1.5), (int) (d.width / 4.5));
        g2.fillOval((int) (d.width / 1.45), d.height - (int) (d.width / 13), (int) (d.width / 3),
                (int) (d.width / 6.75));
    }

    /**
     * Paint the Tree
     */
    public void paintTree(Graphics2D g2, Dimension d) {
        // Trunk
        g2.setPaint(new GradientPaint(0, 0, new Color(153, 63, 0), d.width, d.height, new Color(127, 53, 0), true));
        g2.fillRect((int) (d.width / 5.4), (int) (d.height / 1.5), (int) (d.width / 27), (int) (d.height / 6.136));
        g2.setColor(Color.BLACK);
        g2.drawRect((int) (d.width / 5.4), (int) (d.height / 1.5), (int) (d.width / 27), (int) (d.height / 6.136));
        // Tree Top
        g2.setColor(new Color(34, 139, 34));
        g2.fillOval((int) (d.width / 7.714), (int) (d.height / 3.375), (int) (d.width / 6.716),
                (int) (d.height / 3.358));
        g2.setColor(Color.BLACK);
        g2.drawOval((int) (d.width / 7.714), (int) (d.height / 3.392), (int) (d.width / 6.683),
                (int) (d.height / 3.342));
        // Tree Body
        g2.setColor(Color.BLACK);
        g2.drawLine((int) (d.width / 7.759), (int) (d.height / 2.25), (int) (d.width / 7.759),
                (int) (d.height / 1.424));
        g2.drawLine((int) (d.width / 3.590), (int) (d.height / 2.25), (int) (d.width / 3.590),
                (int) (d.height / 1.424));

        int treeBot[] = { 175, 242, 310, 442, 442, 67, 68, 416, 201, 58 };
        int treeMid[] = { 175, 242, 310, 384, 384, 67, 68, 358, 201, 58 };
        int treeTop[] = { 175, 242, 310, 326, 326, 67, 68, 300, 201, 58 };
        int treeTop1[] = { 175, 242, 310, 268, 258, 67, 68, 290, 199, 10 };
        paintTreePart(g2, treeBot);
        paintTreePart(g2, treeMid);
        paintTreePart(g2, treeTop);
        paintTreePart(g2, treeTop1);
    }

    /**
     * Helper Function for paintTree
     */
    public void paintTreePart(Graphics2D g2, int tree[]) {
        g2.setColor(Color.BLACK);
        g2.drawOval(tree[0] - 1, tree[3] - 1, tree[5], tree[5]);
        g2.drawOval(tree[1] - 1, tree[3] - 1, tree[6], tree[6]);
        g2.drawOval(tree[2] - 1, tree[3] - 1, tree[5], tree[5]);
        g2.setColor(new Color(34, 139, 34));
        g2.fillOval(tree[0], tree[4], tree[5] - 1, tree[5] - 1);
        g2.fillOval(tree[1], tree[4], tree[6] - 1, tree[6] - 1);
        g2.fillOval(tree[2], tree[4], tree[5] - 1, tree[5] - 1);
        g2.fillRect(tree[0], tree[7], tree[8], tree[9]);
    }

    /**
     * Paint the Roof
     */
    public void paintRoof(Graphics2D g2, Dimension d) {
        // Roof
        g2.setPaint(new GradientPaint(0, 0, new Color(204, 58, 51), d.width, d.height, new Color(180, 22, 14), true));
        g2.fillOval(475, 125, 400, 250);
        // White dots on roof
        g2.setPaint(
                new GradientPaint(0, 0, new Color(204, 204, 204), d.width, d.height, new Color(204, 204, 204), true));
        g2.fillOval(475, 195, 45, 110);
        g2.fillOval(830, 195, 45, 110);
        g2.fillOval(590, 135, 170, 170);
        // Outline
        g2.setColor(Color.BLACK);
        g2.drawOval(475, 125, 400, 250);
        g2.drawOval(475, 195, 45, 110);
        g2.drawOval(830, 195, 45, 110);
        g2.drawOval(590, 135, 170, 170);
        // Coverup
        g2.setStroke(new BasicStroke(10));
        g2.setPaint(new GradientPaint(0, 0, new Color(240, 110, 205), 0, d.height, new Color(240, 215, 35), true));
        g2.drawOval(469, 119, 412, 262);
        g2.setStroke(new BasicStroke(1));
    }

    /**
     * Paint the House
     */
    public void paintHouse(Graphics2D g2, Dimension d) {
        // Curb
        g2.setPaint(new GradientPaint(0, 0, new Color(127, 51, 0), d.width, d.height, new Color(76, 30, 0), true));
        g2.fillOval(530, 474, 290, 65);
        g2.setColor(Color.BLACK);
        g2.drawOval(530, 474, 290, 65);
        // Outline
        g2.setColor(Color.BLACK);
        g2.drawOval(549, 451, 251, 76);
        g2.drawRect(549, 348, 251, 138);
        g2.drawOval(550, 314, 250, 70);
        // Fill
        g2.setPaint(new GradientPaint(0, 0, new Color(255, 237, 153), d.width, d.height, new Color(229, 190, 0), true));
        g2.fillRect(550, 348, 250, 137);
        g2.fillOval(550, 450, 250, 76);
        g2.fillOval(550, 315, 250, 75);
    }

    /**
     * Paint the Door Frame and Door on the House
     */
    public void paintDoor(Graphics2D g2, Dimension d) {
        // Frame Outline
        g2.setColor(Color.BLACK);
        g2.drawOval(599, 339, 151, 125);
        g2.drawRect(599, 402, 151, 117);
        g2.drawOval(599, 507, 151, 20);
        // Gold Frame
        g2.setPaint(new GradientPaint(0, 0, new Color(218, 165, 32), d.width, d.height, new Color(218, 165, 32), true));
        g2.fillOval(600, 340, 150, 125);
        g2.fillRect(600, 403, 150, 115);
        g2.fillOval(600, 507, 150, 20);
        // Door Outline
        g2.setColor(Color.BLACK);
        g2.drawOval(609, 350, 131, 110);
        g2.drawRect(609, 402, 131, 116);
        g2.drawOval(609, 511, 131, 17);
        // Brown Door
        g2.setPaint(new GradientPaint(0, 0, new Color(153, 63, 0), d.width, d.height, new Color(127, 53, 0), true));
        g2.fillOval(610, 351, 130, 110);
        g2.fillRect(610, 403, 130, 116);
        g2.fillOval(610, 511, 130, 17);
        // Doorknob
        g2.setPaint(new GradientPaint(0, 0, new Color(218, 165, 32), d.width, d.height, new Color(218, 165, 32), true));
        g2.fillOval(615, 450, 20, 20);
        g2.setColor(Color.BLACK);
        g2.drawOval(615, 450, 20, 20);
        // Door Panels
        g2.drawLine(650, 355, 650, 527);
        g2.drawLine(700, 355, 700, 527);
    }

    /**
     * Paint the Windows on the House
     */
    public void paintWindows(Graphics2D g2, Dimension d) {
        // Gold Frame
        g2.setStroke(new BasicStroke(5));
        g2.setPaint(new GradientPaint(0, 0, new Color(218, 165, 32), d.width, d.height, new Color(218, 165, 32), true));
        g2.drawOval(780, 380, 40, 60);
        g2.drawOval(530, 380, 40, 60);
        // Glass
        g2.setColor(new Color(135, 206, 250, 127));
        g2.fillOval(783, 380, 45, 60);
        g2.setColor(new Color(135, 206, 250, 150));
        g2.fillOval(525, 380, 45, 60);
        // Window Lines
        g2.setPaint(new GradientPaint(0, 0, new Color(218, 165, 32), d.width, d.height, new Color(218, 165, 32), true));
        g2.drawLine(780, 410, 800, 410);
        g2.drawLine(800, 380, 800, 440);
        g2.drawLine(550, 410, 570, 410);
        g2.drawLine(550, 380, 550, 440);
        // Outlines
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.BLACK);
        g2.drawOval(778, 378, 45, 65);
        g2.drawOval(782, 380, 46, 61);
        g2.drawOval(529, 378, 45, 65);
        g2.drawOval(524, 380, 46, 61);
        // Coverups
        g2.setPaint(new GradientPaint(0, 0, new Color(240, 110, 205), 0, d.height, new Color(240, 215, 35), true));
        g2.fillRect(800, 370, 30, 80);
        g2.fillRect(520, 370, 30, 80);
        g2.setColor(Color.BLACK);
        g2.drawLine(800, 370, 800, 450);
        g2.drawLine(549, 370, 549, 450);
    }

    /**
     * Paint the ToadHouse using the above functions
     */
    public void paint(Graphics g) {

        Dimension d = getSize();
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintSky(g2, d);

        paintSun(g2, d);

        double cloud1x[] = { 1.500, 1.480, 1.480, 1.464, 1.430, 1.430, 1.430, 1.396, 1.372, 1.372, 1.355 };
        double cloud1y[] = { 11.500, 9.352, 15.000, 11.500, 9.325, 15.000, 11.500, 11.500, 9.325, 15.000, 11.500 };
        double cloud2x[] = { 3.325, 3.475, 3.475, 3.525, 3.750, 3.750, 3.750, 4.000, 4.120, 4.120, 4.285 };
        double cloud2y[] = { 15.000, 11.500, 21.555, 15.000, 11.500, 21.555, 15.000, 15.000, 11.500, 21.555, 15.0000 };
        paintClouds(g2, d, cloud1x, cloud1y);
        paintClouds(g2, d, cloud2x, cloud2y);

        int mountain1Top[] = { 1000, 80, 200, 200 };
        int mountain1Bod[] = { 1000, 190, 200, 400 };
        int mountain1Eyes[] = { 1060, 1120, 155, 20, 60 };
        int mountain2Top[] = { 1150, 230, 300, 300 };
        int mountain2Bod[] = { 1150, 360, 300, 300 };
        int mountain2Eyes[] = { 1250, 1310, 280, 20, 60 };
        paintMountain(g2, d, mountain1Top, mountain1Bod, mountain1Eyes);
        paintMountain(g2, d, mountain2Top, mountain2Bod, mountain2Eyes);

        paintGround(g2, d);
        paintTree(g2, d);

        paintRoof(g2, d);
        paintHouse(g2, d);
        paintDoor(g2, d);
        paintWindows(g2, d);
    }
}
