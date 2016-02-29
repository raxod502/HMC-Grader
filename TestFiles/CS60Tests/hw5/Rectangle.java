// Interface that describes any class that implements
//   rectangles (whose sides are parallel to the x and y axes)

public interface Rectangle {
	
	// We can ask any rectangle for its corners
	public Point lowerLeft();
	public Point lowerRight();
	public Point upperLeft();
	public Point upperRight();
	
	// We can ask any rectangle for its center
	public Point center();
	
	// We can ask any rectangle for its width and height,
	//    which must be nonnegative
	public double width();
	public double height();
	
	// We can move any rectangle some distance in the x and y directions.
	public void move(double deltaX, double deltaY);
	
	// We can ask a rectangle whether it contains a specific point p
	//    in its interior; points on the boundary of the rectangle 
	//    do NOT count.
	public boolean interior(Point p);
	
	// We can ask whether this object overlaps with any other rectangle.
	//    To be an overlap, the intersection of the two rectangles
	//    must have a non-zero area; sharing an edge or a corner isn't enough.
	public boolean overlaps(Rectangle other);
}
