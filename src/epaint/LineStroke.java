package epaint;
import java.awt.Color;
import java.awt.geom.*;
import java.io.Serializable;

public class LineStroke implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Color clr;
    private int sze;
    private Line2D lineBuffer;
    private Path2D path;
    
    public LineStroke()
    {
        this.clr=Color.BLACK;
        this.sze=1;
        this.lineBuffer = null;
        this.path = null;
    
    }
    
    public LineStroke(Color col, int siz, Path2D pth)
    {
        this.clr=col;
        this.sze=siz;
        this.path = pth;
         this.lineBuffer = null;
    }
   
    public LineStroke(Color col,int siz, Line2D lin)
    {   
        this.clr=col;
        this.sze=siz;
        this.lineBuffer = lin;
        
        this.path = null;

    }
    
    
    public int getSize()
    {
        return this.sze;
    }
    
    public Color getColor()
    {
        return this.clr;
    }
    public Line2D getLinebuffer()
    {
        return this.lineBuffer;
    }
    public Path2D getPath(){
    return this.path;
    }
            
    
    
}
