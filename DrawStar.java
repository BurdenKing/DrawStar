package q2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * <p>Draws an star whose size is based on the mouse dragged and
 * draws a circle in the midpoint of the star.</p>
 *
 * @author Lawrence Zheng
 * @version 1.0
 */
public class DrawStar extends Application {
        
    /**
     * Constant used to obtain the 2nd point of the star at 120 degrees
     * from the origin.
     */
    private static final double SIN72 = Math.sin(Math.toRadians(72));
    
    /**
     * Constant used to obtain the 2nd point of the star at 120 degrees
     * from the origin.
     */
    private static final double NEG_SIN72 = -(Math.sin(Math.toRadians(72)));
    
    /**
     * Constant used to obtain the 2nd point of the star at 120 degrees
     * from the origin.
     */
    private static final double COS72 = Math.cos(Math.toRadians(72));
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double SIN144 = Math.sin(Math.toRadians(144));
   
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double NEG_SIN144 = -(Math.sin(Math.toRadians(144)));
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double COS144 = Math.cos(Math.toRadians(144));
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double SIN216 = Math.sin(Math.toRadians(216));
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double NEG_SIN216 = -(Math.sin(Math.toRadians(216)));
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double COS216 = Math.cos(Math.toRadians(216));
    
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double SIN288 = Math.sin(Math.toRadians(288));
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double NEG_SIN288 = -(Math.sin(Math.toRadians(288)));
    
    /**
     * Constant used to obtain the 3rd point of the star at 240 degrees
     * from the origin.
     */
    private static final double COS288 = Math.cos(Math.toRadians(288));
    
    /**
     * Radius of the centre circle.
     */
    private static final int CIRCLE_RADIUS = 3;
    
    /**
     * The contents of the application scene. 
     */
    private Group root;
    
    /** 
     * Circle to move to first mouse click location. 
     */
    private Circle atCenter;
    
    /**
     * Line for the first line of the star.
     */
    private Line side1;
    
    /**
     * Line for the second line of the star.
     */
    private Line side2;
    
    /**
     * Line for the third line of the star.
     */
    private Line side3;
   
    /**
     * Line for the third line of the star.
     */
    private Line side4;
    
    /**
     * Line for the third line of the star.
     */
    private Line side5;
   
    /**
     * Displays an initially empty scene, waiting for the user to draw lines
     * with the mouse.
     * 
     * @param primaryStage
     *            a Stage
     */
    public void start(Stage primaryStage) {
        root = new Group();
        final int appWidth = 800;
        final int appHeight = 500;
        Scene scene = new Scene(root, appWidth, appHeight, Color.BLACK);
        
        // Instantiation of the shapes.
        side1 = new Line(0, 0, 0, 0);
        side2 = new Line(0, 0, 0, 0);
        side3 = new Line(0, 0, 0, 0);
        side4 = new Line(0, 0, 0, 0);
        side5 = new Line(0, 0, 0, 0);
        atCenter = new Circle(0, 0, CIRCLE_RADIUS);
        
        // Methods to process mouse events
        scene.setOnMousePressed(this::processMousePress);
        scene.setOnMouseReleased(this::processMouseDrag);
        
        // Setting circle and line colors.
        atCenter.setFill(Color.CYAN);
        side1.setStroke(Color.CYAN);
        side2.setStroke(Color.CYAN);
        side3.setStroke(Color.CYAN);
        side4.setStroke(Color.CYAN);
        side5.setStroke(Color.CYAN);
        
        // Adding shapes to the root
        root.getChildren().add(atCenter);
        root.getChildren().add(side1);
        root.getChildren().add(side2);
        root.getChildren().add(side3);
        root.getChildren().add(side4);
        root.getChildren().add(side5);        

        // Sets up primary stage.
        primaryStage.setTitle("Star");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Draws a circle at the center of the star.
     * @param event invokes this method.
     */
    public void processMousePress(MouseEvent event) {
        
        // Creates a circle at the point of the mouse press.
        atCenter.setCenterX(event.getX());
        atCenter.setCenterY(event.getY());
    }
    
    /**
     * Draws an  star with a size relative
     * to the current mouse location from the original click location.
     * @param event invokes this method.
     */
    public void processMouseDrag(MouseEvent event) {
        
        
        // Used to offset points of the star within the window.
        double centerX = atCenter.getCenterX();
        double centerY = atCenter.getCenterY();
        

        double point1X = event.getX() - centerX;
        double point1Y = event.getY() - centerY;

        double point2X = (COS72 * point1X) + (SIN72 * point1Y) + centerX;
        double point2Y = (NEG_SIN72 * point1X) + (COS72 * point1Y) + centerY;
        
        double point3X = (COS144 * point1X) + (SIN144 * point1Y) + centerX;
        double point3Y = (NEG_SIN144 * point1X) + (COS144 * point1Y) + centerY;
        
        
        double point4X = (COS216 * point1X) + (SIN216 * point1Y) + centerX;
        double point4Y = (NEG_SIN216 * point1X) + (COS216 * point1Y) + centerY;
       
        double point5X = (COS288 * point1X) + (SIN288 * point1Y) + centerX;
        double point5Y = (NEG_SIN288 * point1X) + (COS288 * point1Y) + centerY;
                

        // Assigning coordinates for the 1st line.
        side1.setStartX(event.getX());
        side1.setStartY(event.getY());
        side1.setEndX(point3X);
        side1.setEndY(point3Y);
        
       // Assigning coordinates for the 2nd line.
        side2.setStartX(point3X);
        side2.setStartY(point3Y);
        side2.setEndX(point5X);
        side2.setEndY(point5Y);
        
       // Assigning coordinates for the 3rd line.
        side3.setStartX(point5X);
        side3.setStartY(point5Y);
        side3.setEndX(point2X);
        side3.setEndY(point2Y);
        
        side4.setStartX(point2X);
        side4.setStartY(point2Y);
        side4.setEndX(point4X);
        side4.setEndY(point4Y);
        
        side5.setStartX(point4X);
        side5.setStartY(point4Y);
        side5.setEndX(event.getX());
        side5.setEndY(event.getY());
}

    /**
     * Launches the JavaFX application.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
