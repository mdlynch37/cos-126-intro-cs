public class Lecture13 { 
    public static void main(String[] args) {
        Picture source = new Picture(args[0]); 
        int width = source.width(); 
        int height = source.height();
        Picture target = new Picture(width, height); 
        for (int x = 0; x < width; x++) 
            for (int y = 0; y < height; y++) 
            target.set(x, height - y - 1, source.get(x, y)); 
        target.show();
    }
}