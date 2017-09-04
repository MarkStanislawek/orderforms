package mannafundraising.orderforms.service;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JEditorPane;

import org.springframework.stereotype.Component;

@Component
public class ImageServiceImpl implements ImageService {

	@Override
	public List<byte[]> createImageFromHtml(List<byte[]> htmlPages) throws IOException {
		List<byte[]> images = new ArrayList<>(htmlPages.size());
		for (Iterator<byte[]> it = htmlPages.iterator(); it.hasNext();) {
			JEditorPane pane = new JEditorPane("text/html", new String(it.next()));
			pane.setSize(pane.getPreferredSize());
			int width = (int)pane.getPreferredSize().getWidth();
			int height = (int)pane.getPreferredSize().getHeight();
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			Graphics2D graphics = image.createGraphics();
			pane.print(graphics);
			ByteArrayOutputStream ostream = new ByteArrayOutputStream();
			ImageIO.write(image, "PNG", ostream);
			images.add(ostream.toByteArray());
		}
		return images;
	}

}
