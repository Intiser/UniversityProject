/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv.camera.test;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    private static boolean applicationShouldClose = false;
    private Mat prevFrame;
    private Mat frame;
    private int difference[][];
    private int flag[][];
    private int marker[][]; //area marking array
    private int xMin;
    private int yMin;
    private int xMax;
    private int yMax;
    
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    @FXML
    private ImageView cameraView;
    private VideoCapture videoCapture;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        videoCapture = new VideoCapture();
        prevFrame = new Mat();
        
       
    }

    @FXML
    private void handleStartCameraAction(ActionEvent event) {
        videoCapture.open(0);
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> cameraView.setImage(grabFrame()), 0, 100, TimeUnit.MILLISECONDS);
    }

    private Image grabFrame() {
        if (applicationShouldClose) {
            if (videoCapture.isOpened()) {
                videoCapture.release();
            }
            scheduledExecutorService.shutdown();
        }
        
        Image imageToShow = null;
        frame = new Mat();
        
        int frameNum = 0;
        if (videoCapture.isOpened()) {
            try {
                videoCapture.read(frame);
                int height = frame.rows();
                int width = frame.cols(); 
                difference = new int[height+5][width+5];
                flag = new int[height+5][width+5];
                marker = new int[height+5][width+5];
                if (!frame.empty()) {
                    Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2GRAY);
                    
                    
                   // code for brightening a region 
                   /* for (int r = 300; r < 400; r++)
                        for (int c = 300; c < 400; c++) {
                            double value[] = frame.get(r, c);
                            double newValue = value[0] * 1.25;
                            if (newValue > 255)
                                newValue = 255;
                            frame.put(r, c, newValue);
                        }
                    
                    */
                   if(!prevFrame.empty())
                    for (int r = 0; r < height; r++){
                        for (int c = 0; c < width; c++) {
                            double value[] = frame.get(r, c);
                            double pvalue[] = prevFrame.get(r, c);
                            difference[r][c] =(int)Math.abs(value[0]-pvalue[0]);
                            if (difference[r][c] <= 20)
                                difference[r][c] = 0;
                            flag[r][c] = 0;
                            
                            //System.out.print(difference[r][c]);
                        }                        
                    }
                    //System.out.println(difference.toString());
                    int cnt = 1;
                    prevFrame = frame.clone();
                    for(int i=0;i<height;i++){
                        for(int j=0;j<width;j++){
                            if(difference[i][j]>0&&flag[i][j]==0){
                                xMin = height;
                                xMax = 0;
                                yMin = width;
                                yMax = 0;
                                int get = floodfill(i,j,height,width,cnt);
                                if(get>5000){
                                    cnt++;
                                    border();
                                }
                            }
                        }
                    }
                    //System.out.println(cnt + " " + width + " " + height );
                    MatOfByte buffer = new MatOfByte();
                    Imgcodecs.imencode(".png", frame, buffer);
                    imageToShow = new Image(new ByteArrayInputStream(buffer.toArray()));
                }

            } catch (Exception e) {
                System.err.println(e);
            }
        }

        return imageToShow;
    }
    
    private int dx[] = {0,0,-1,1,-1,-1,1,1};
    private int dy[] = {-1,1,0,0,-1,1,1,-1};
    
    int floodfill(int x,int y, int h,int w,int clr){
        if(x<0||x==h||y<0||y==w||flag[x][y]==1) return 0;
        flag[x][y] = 1;
        int ret = 0;
        if(difference[x][y]==0){ 
            marker[x][y] = 0;
            return 0;
        }
        
        marker[x][y] = clr; 
        minMaxUpdate(x,y);
        ret = 1;
        for(int i=0;i<8;i++){
            int X = x + dx[i];
            int Y = y + dy[i];
            ret = ret + floodfill(X,Y,w,h,clr);
        }
        return ret;
    }
    
    
    void minMaxUpdate(int x,int y){
        if(x>xMax) xMax = x;
        if(x<xMin) xMin = x;
        if(y>yMax) yMax = y;
        if(y<yMin) yMin = y;
    }
    
    void border(){
        for(int i = xMin ; i<=xMax ;i++){
            frame.put(i, yMin, 0);
            frame.put(i, yMin+1, 0);
            frame.put(i, yMax, 0);
            frame.put(i, yMax-1, 0);
        }
        for(int i = yMin ; i<=yMax ;i++){
            frame.put( xMin,i, 0);
            frame.put( xMin+1,i, 0);
            frame.put( xMax,i, 0);
            frame.put( xMax-1,i, 0);
        }
    }

    @FXML
    private void handleStopCameraAction(ActionEvent event) {
        if (videoCapture.isOpened()) {
            videoCapture.release();
        }
        scheduledExecutorService.shutdown();
    }

    public static void exit() {
        applicationShouldClose = true;
    }
}
