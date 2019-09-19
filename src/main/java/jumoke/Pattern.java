package jumoke;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


/**
 * Class <b>Pattern</b><br>
 * A pattern is used, to associate an image file with additional attributes
 * used in find operations and when acting on a match object.
 *
 * @author Astakhov Vladimir [VIAstakhov@mail.ru]
 * @version 2.0
 */
public class Pattern {
    private String imgpath = null;
    private BufferedImage bImage = null;
    float similarity = 0.95f;
    private Location offset = new Location(0, 0);


    /**
     * Constructor <b>Pattern</b><br>
     * This will initialize a new pattern object without any additional attributes.
     * As long as no pattern methods are used additionally, it is the same as just
     * using the image file name itself in the find operation.</br><p>
     *
     * @param imgURL - a path to an image file.
     * @return Returns a new pattern object.
     */
    public Pattern(String imgURL) {
        Agent.log.info(">> " + "imgURL = " + imgURL);
        this.imgpath = imgURL;
        this.bImage = loadBufferedImage(new File(imgURL));
        Agent.log.info("<< " + this.bImage.toString());
    }


    private BufferedImage loadBufferedImage(File file) {
        this.bImage = null;

        if (file != null) {
            try {
                bImage = ImageIO.read(file);
            } catch (Exception e) {
                Agent.log.info("File could not be loaded: " + file);
                file = null;
                return null;
            }
        }
        return bImage;
    }

    /**
     * Method <b>similar</b><br>
     * Return a new Pattern object containing the same attributes (image, click point)
     * with the minimum similarity set to the specified value.<br><p>
     *
     * @param similarity -  the minimum similarity to use in a find operation. The value should be between 0 and 1.
     * @return Returns a new pattern object.
     */
    public Pattern similar(float similarity) {
        Agent.log.info(">> " + "similarity = " + similarity);
        this.similarity = similarity;
        Agent.log.info("<< " + this.toString());
        return this;
    }

    /**
     * Method <b>exact</b><br>
     * Return a new Pattern object containing the same attributes (image, click point)
     * with the minimum similarity set to 1.0, which means exact match is required.<br><p>
     *
     * @return Returns a new pattern object.
     */
    public Pattern exact() {
        return similar(1.0f);
    }

    /**
     * Method <b>targetOffset</b><br>
     * Return a new Pattern object containing the same attributes (image, similarity), but a different definition for
     * the click. By default, the click point is the center of the found match. By setting the target offset,
     * it is possible to specify a click point other than the center. dx and dy will be used to calculate the position
     * relative to the center.<br><p>
     *
     * @param dx - x offset from the center
     * @param dy - y offset from the center
     * @return Returns a new pattern object.
     */
    public Pattern targetOffset(int dx, int dy) {
        Agent.log.info(">> " + "dx = " + dx + ", dy = " + dy);
        offset.x = dx;
        offset.y = dy;
        Agent.log.info("<< " + offset.toString());
        return this;
    }

    @Override
    public String toString() {
        String ret = "S: " + similarity;

        if (offset.x != 0 || offset.y != 0) {
            ret += " T: " + offset.x + "," + offset.y;
        }

        return ret;
    }

    /**
     * Method <b>getFilename</b><br>
     * Get the filename of the image contained in the Pattern object.</br><p>
     *
     * @return Returns a filename as a string.
     */
    public String getFilename() {
        if (!imgpath.isEmpty() && !bImage.equals(null)) {
            File file;
            file = new File(imgpath);
            return file.getAbsolutePath();
        }

        return null;
    }
}


