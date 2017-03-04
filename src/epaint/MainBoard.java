package epaint;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.*;
import java.util.*;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class MainBoard extends javax.swing.JFrame implements Serializable {

    private Stroke s;
    private static final long serialVersionUID = 1L;

    private int port = 7777;
    private String ip = "192.168.0.50";
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private Shape shape;
    private Shape eshape;
    private final String filepath = "Image.png";
    private Line2D lineBuffer;
    private Path2D path;
    private Path2D epath;
    private Graphics g=null;
    Graphics2D g2 = (Graphics2D) g;
    private int exitChange = 0;
    private List<LineStroke> lineContainer = new ArrayList<LineStroke>();
    private List<LineStroke> lineContainer2 = new ArrayList<LineStroke>();
    private List<java.awt.event.MouseEvent> eventContainer = new ArrayList<java.awt.event.MouseEvent>();
    transient ServerSocket serverSock;
    transient ObjectInputStream OIS;
    transient ObjectOutputStream OOS;
    transient Socket sock;
    boolean isHost = false;
    boolean isClient = false;
    int x, y;

    public MainBoard() throws IOException {
        initComponents();
    }
    
    		class verticalAdjust implements AdjustmentListener {
			public void adjustmentValueChanged(AdjustmentEvent e){
                                drawarea.updateUI();
			}
		}
		

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolsgroup = new javax.swing.ButtonGroup();
        tools = new javax.swing.JLabel();
        brush = new javax.swing.JRadioButton();
        line = new javax.swing.JRadioButton();
        eraser = new javax.swing.JRadioButton();
        drawarea = new javax.swing.JPanel();
        colorchoose = new javax.swing.JColorChooser();
        sizeslider = new javax.swing.JSlider();
        jTextArea1 = new javax.swing.JTextArea();
        tools1 = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        newimage = new javax.swing.JMenuItem();
        join = new javax.swing.JMenuItem();
        Undo = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        export = new javax.swing.JMenuItem();
        close = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tools.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tools.setText("TOOLS");

        toolsgroup.add(brush);
        brush.setSelected(true);
        brush.setText("Brush");
        brush.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brushActionPerformed(evt);
            }
        });

        toolsgroup.add(line);
        line.setText("Line");
        line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineActionPerformed(evt);
            }
        });

        toolsgroup.add(eraser);
        eraser.setText("Eraser");
        eraser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraserActionPerformed(evt);
            }
        });

        drawarea.setBackground(new java.awt.Color(255, 255, 255));
        drawarea.setPreferredSize(new java.awt.Dimension(0, 500));
        drawarea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                drawareaMouseDragged(evt);
            }
        });
        drawarea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawareaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                drawareaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout drawareaLayout = new javax.swing.GroupLayout(drawarea);
        drawarea.setLayout(drawareaLayout);
        drawareaLayout.setHorizontalGroup(
            drawareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawareaLayout.setVerticalGroup(
            drawareaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        colorchoose.setToolTipText("");

        sizeslider.setMaximum(20);
        sizeslider.setValue(10);
        sizeslider.setMaximumSize(new java.awt.Dimension(3276, 26));
        sizeslider.setValueIsAdjusting(true);

        jTextArea1.setColumns(8);
        jTextArea1.setRows(1);

        tools1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tools1.setText("SIZE");

        menu.setText("Main Menu");

        newimage.setText("New Image");
        newimage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newimageActionPerformed(evt);
            }
        });
        menu.add(newimage);

        join.setText("Join");
        join.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinActionPerformed(evt);
            }
        });
        menu.add(join);

        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        menu.add(Undo);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    saveActionPerformed(evt);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.add(save);

        export.setText("Export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });
        menu.add(export);

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    closeActionPerformed(evt);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.add(close);

        menubar.add(menu);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(colorchoose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tools)
                .addGap(18, 18, 18)
                .addComponent(brush)
                .addGap(18, 18, 18)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eraser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(tools1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeslider, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(drawarea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drawarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sizeslider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tools1)
                        .addComponent(tools)
                        .addComponent(brush)
                        .addComponent(line)
                        .addComponent(eraser)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorchoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void drawAll(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        lineContainer.addAll(lineContainer2);
        if (g2 == null) {
            g2 = (Graphics2D) drawarea.getGraphics();
        }
        if(lineContainer.isEmpty()==false){
        for (int i = 0; i < lineContainer.size(); i++) {
            g2.setStroke(new BasicStroke(lineContainer.get(i).getSize()));
            g2.setColor(lineContainer.get(i).getColor());
            if (lineContainer.get(i).getLinebuffer() == null) {
                g2.draw(lineContainer.get(i).getPath());
            } else {
                g2.draw(lineContainer.get(i).getLinebuffer());
            }
        }
        }
        else{
        g2.setColor(Color.white);
        g2.fillRect(0, 0, drawarea.getWidth() , drawarea.getHeight());}
        System.out.println(lineContainer.size());
        
    }


    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        JFileChooser c = new JFileChooser();
        javax.swing.filechooser.FileFilter[] allFilter = c.getChoosableFileFilters();
        c.removeChoosableFileFilter(allFilter[0]);
        FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("png", "png");
        FileNameExtensionFilter btmFilter = new FileNameExtensionFilter("btm", "btm");
        FileNameExtensionFilter gifFilter = new FileNameExtensionFilter("gif", "gif");
        FileNameExtensionFilter jpegFilter = new FileNameExtensionFilter("jpg", "jpg");
        c.addChoosableFileFilter(jpegFilter);
        c.addChoosableFileFilter(gifFilter);
        c.addChoosableFileFilter(btmFilter);
        c.addChoosableFileFilter(pngFilter);

        int rVal = c.showSaveDialog(MainBoard.this);
        //if u want to remember filename or dir:
        // if (rVal == JFileChooser.APPROVE_OPTION){
        // filename.setText(c.getSelectedFile().getName());
        // dir.setText(c.getCurrentDirectory().toString());}

        BufferedImage image = new BufferedImage(drawarea.getWidth(), drawarea.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.fillRect(0, 0, drawarea.getWidth(), drawarea.getHeight());
        drawAll(g);

        try {

            ImageIO.write(image, c.getFileFilter().getDescription(), new File(c.getSelectedFile().getPath() + c.getSelectedFile().getName() + '.' + c.getFileFilter().getDescription()));
        } catch (IOException ex) {
            Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) throws ParserConfigurationException, TransformerException {//GEN-FIRST:event_closeActionPerformed
        if (exitChange != lineContainer.size()) {
            int reply = JOptionPane.showConfirmDialog(null, "Do you want to save changes?", "exit", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                saveActionPerformed(evt);
                System.exit(0);
            } else {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }//GEN-LAST:event_closeActionPerformed

    private void lineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lineActionPerformed

    private void drawareaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawareaMousePressed
        // TODO add your handling code here:

        if (g2 == null) {
            g2 = (Graphics2D) drawarea.getGraphics();
        }
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        xStart = evt.getX();
        yStart = evt.getY();
        xEnd = evt.getX();
        yEnd = evt.getY();

        Path2D path = new Path2D.Float();
        LineStroke Brush = new LineStroke(colorchoose.getColor(), sizeslider.getValue(), path);
        shape = Brush.getPath();

        Path2D epath = new Path2D.Float();
        LineStroke eBrush = new LineStroke(Color.WHITE, 10 + sizeslider.getValue(), epath);
        eshape = eBrush.getPath();

        if (eraser.isSelected()) {
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(10 + sizeslider.getValue()));
        } else {
            g2.setColor(colorchoose.getColor());
            g2.setStroke(new BasicStroke(sizeslider.getValue()));
        }
        drawAll(g2);

    }//GEN-LAST:event_drawareaMousePressed

    private void drawareaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawareaMouseDragged
        // TODO add your handling code here:
        
        if (g2 == null) {
            g2 = (Graphics2D) drawarea.getGraphics();
        }
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawarea.update(g2);
        xEnd = evt.getX();
        yEnd = evt.getY();

        if (line.isSelected()) {
            lineBuffer = new Line2D.Float((float) xStart, (float) yStart, (float) xEnd, (float) yEnd);
            LineStroke lin = new LineStroke(colorchoose.getColor(), sizeslider.getValue(), lineBuffer);
            g2.setColor(colorchoose.getColor());
            g2.setStroke(new BasicStroke(sizeslider.getValue()));
            g2.draw(lin.getLinebuffer());
        }

        if (brush.isSelected()) {
            Path2D path = new Path2D.Float(shape);
            path.moveTo(xStart, yStart);
            path.lineTo(xEnd, yEnd);
            LineStroke Brush = new LineStroke(colorchoose.getColor(), sizeslider.getValue(), path);
            shape = Brush.getPath();

            xStart = xEnd;
            yStart = yEnd;
            g2.setColor(colorchoose.getColor());
            g2.setStroke(new BasicStroke(sizeslider.getValue()));
            g2.draw(Brush.getPath());
        }

        if (eraser.isSelected()) {
            Path2D epath = new Path2D.Float(eshape);
            epath.moveTo(xStart, yStart);
            epath.lineTo(xEnd, yEnd);
            LineStroke eBrush = new LineStroke(Color.WHITE, 10 + sizeslider.getValue(), epath);
            eshape = eBrush.getPath();
            xStart = xEnd;
            yStart = yEnd;
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(10 + sizeslider.getValue()));
            g2.draw(eBrush.getPath());
        }
       
        eventContainer.add(evt);
        drawAll(g2);

    }//GEN-LAST:event_drawareaMouseDragged

    private void drawareaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawareaMouseReleased
        // TODO add your handling code here:
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawarea.update(g2);
        LineStroke lin = null;
        if (line.isSelected()) {
            xEnd = evt.getX();
            yEnd = evt.getY();
            lineBuffer = new Line2D.Float((float) xStart, (float) yStart, (float) xEnd, (float) yEnd);
            lin = new LineStroke(colorchoose.getColor(), sizeslider.getValue(), lineBuffer);
            g2.setColor(colorchoose.getColor());
            g2.setStroke(new BasicStroke(sizeslider.getValue()));

        }
        if (brush.isSelected()) {
            path = new Path2D.Float(shape);
            lin = new LineStroke(colorchoose.getColor(), sizeslider.getValue(), path);
            shape = lin.getPath();
            g2.setColor(colorchoose.getColor());
            g2.setStroke(new BasicStroke(sizeslider.getValue()));

        }
        if (eraser.isSelected()) {
            epath = new Path2D.Float(eshape);
            lin = new LineStroke(Color.WHITE, 10 + sizeslider.getValue(), epath);
            eshape = lin.getPath();
            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(10 + sizeslider.getValue()));

        }
        lineContainer.add(lin);
        
        

        if (isClient == true || isHost== true) {
            try {

OOS.writeObject(lin);
OOS.writeObject(null);
                   OOS.flush();


            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        drawAll(g2);
    }//GEN-LAST:event_drawareaMouseReleased

    private void eraserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraserActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_eraserActionPerformed

    private void joinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinActionPerformed
        String portString = JOptionPane.showInputDialog("Input port (1 to 65535)");
        port=Integer.parseInt(portString);
        if(port<=65535 && port>=1){
        ip = JOptionPane.showInputDialog("Input ip given by server");
        isClient = true;
        newimage.setEnabled(false);
        lineContainer.clear();
        drawAll(g2);
       

        try {
            sock = new Socket(ip, port);
        } catch (IOException ex) {
            Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"try once again");
            isClient = false;
        newimage.setEnabled(true);
        }
        if(OIS!=null)
            OIS=null;
        if(OOS!=null)
            OOS=null;
       try {
            OIS = new ObjectInputStream(sock.getInputStream());
            OOS = new ObjectOutputStream(sock.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
        }
        else
            JOptionPane.showMessageDialog(rootPane,"try once again");

    }//GEN-LAST:event_joinActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) throws ParserConfigurationException, TransformerException{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
           
        // root element
         Element rootElement = doc.createElement("details");
         doc.appendChild(rootElement);

         //  supercars element
         Element detname = doc.createElement("detail");
         rootElement.appendChild(detname);

         // setting attribute to element
         Attr attr = doc.createAttribute("type");
         attr.setValue("coordinate");
         detname.setAttributeNode(attr);
            for(int i =0;i<eventContainer.size();i++)
        {
         
         Element dettype = doc.createElement("coordinate");
         Attr attrType = doc.createAttribute("type");
         attrType.setValue("x");
         dettype.setAttributeNode(attrType);
         dettype.appendChild(doc.createTextNode(String.valueOf(eventContainer.get(i).getX()+"   ")));
         detname.appendChild(dettype);
         

         Element dettype1 = doc.createElement("coordinate");
         Attr attrType1 = doc.createAttribute("type");
         attrType1.setValue("y");
         dettype1.setAttributeNode(attrType1);
         dettype1.appendChild(doc.createTextNode(String.valueOf(eventContainer.get(i).getY())+"\n"));
         detname.appendChild(dettype1);
         
         Element detname1 = doc.createElement("details");
         rootElement.appendChild(detname1);
         Attr attr1 = doc.createAttribute("type");
         attr1.setValue("event");
         detname1.setAttributeNode(attr1);
         
         Element dettype2 = doc.createElement("detail");
         Attr attrType2 = doc.createAttribute("type");
         attrType2.setValue("event");
         dettype2.setAttributeNode(attrType2);
         dettype2.appendChild(doc.createTextNode(String.valueOf(eventContainer.get(i))+"\n"));
         detname1.appendChild(dettype2);
         
        }
        
        
        

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("mouseeventdetails.xml"));
        transformer.transform(source, result);    
        
        
    }//GEN-LAST:event_saveActionPerformed

    private void brushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brushActionPerformed

    }//GEN-LAST:event_brushActionPerformed
 
    //from join
    class IncomingReader implements Runnable {
        public IncomingReader() {
          
            }
        

        @Override
        public void run() {
            LineStroke l=null;
            try {           
                while (true) {
                   int i = 0;
                   if(OIS!=null){
                    while ((l = (LineStroke) OIS.readObject()) != null) {
                         if (i == 0) {
                             lineContainer2.clear();
                            i++;
                         }
                        lineContainer2.add(l); 
                    }             
                   }                 
                    if (l == null && i == 0) {
                        lineContainer2.clear();
                    }
                    drawAll(g2);
                    
                }

            } catch (SocketException e) {

            } catch (ClassNotFoundException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    //from newimage
    class pollClients implements Runnable {

        public pollClients() {        }

        public void run() {
            try {
                while (true) {
                    
                    Socket clientSocket = serverSock.accept();
                   // ObjectOutputStream OOS = new ObjectOutputStream(clientSocket.getOutputStream());
                    
                    
       try {
        
            OOS = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
                    
                    for (int i = 0; i < lineContainer.size(); i++) {
                        OOS.writeObject(lineContainer.get(i));
                        OOS.writeObject(null);
                        OOS.flush();
                    }

                    Thread t = new Thread(new clientHandler(clientSocket));
                    t.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    //from poll
    class clientHandler implements Runnable {

        LineStroke l = null;

        public clientHandler(Socket clientSocket) throws ClassNotFoundException {
            try {
                sock = clientSocket;
                OIS = new ObjectInputStream(sock.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    int i = 0;
                   if(OIS!=null){
                    while ((l = (LineStroke) OIS.readObject()) != null) {
                         if (i == 0) {
                             lineContainer2.clear();
                            i++;
                         }
                        lineContainer2.add(l); 
                    }             
                   }                 
                    if (l == null && i == 0) {
                        lineContainer2.clear();
                    }
                    drawAll(g2);
                    
                }
            } catch (SocketException e) {
                System.out.println("Socket terminated");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void newimageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newimageActionPerformed
        String portString = JOptionPane.showInputDialog("Input port (1 to 65535)");
        port=Integer.parseInt(portString);
        if(port<=65535 && port>=1){
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        ip = addr.getHostAddress();
        jTextArea1.setText("ip: " + ip);
        
        
        isHost = true;
        join.setEnabled(false);
        lineContainer.clear();
        drawAll(g2);
        
        try {
            serverSock = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Thread thread = new Thread(new pollClients());
        thread.start();}
        else
            JOptionPane.showMessageDialog(rootPane,"try once again with proper");
        
    }//GEN-LAST:event_newimageActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
       if(lineContainer.isEmpty()==false){
        int i=lineContainer.size();
        lineContainer.remove(i-1);
        drawAll(g2);
                }
    }//GEN-LAST:event_UndoActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainBoard().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(MainBoard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Undo;
    private javax.swing.JRadioButton brush;
    private javax.swing.JMenuItem close;
    private javax.swing.JColorChooser colorchoose;
    private javax.swing.JPanel drawarea;
    private javax.swing.JRadioButton eraser;
    private javax.swing.JMenuItem export;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem join;
    private javax.swing.JRadioButton line;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem newimage;
    private javax.swing.JMenuItem save;
    private javax.swing.JSlider sizeslider;
    private javax.swing.JLabel tools;
    private javax.swing.JLabel tools1;
    private javax.swing.ButtonGroup toolsgroup;
    // End of variables declaration//GEN-END:variables
}
