package mannafundraising.orderforms.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

@Component
public class ITextPdfService implements PdfService {

	@Override
	public byte[] createPdfFromHtml(List<byte[]> pages) throws DocumentException, IOException {
		Document document = new Document(PageSize.LETTER, 2.5f, 2.5f, 2.5f, 2.5f);
		document.addAuthor(this.getClass().getCanonicalName());
		document.addCreationDate();
		document.addSubject("Manna Order Form");
		ByteArrayOutputStream oStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, oStream);
		document.open();
		for (Iterator<byte[]> i = pages.iterator(); i.hasNext();) {
			XMLWorkerHelper.getInstance().parseXHtml(writer, document, new ByteArrayInputStream(i.next()));
			if (i.hasNext())
				document.newPage();
		}
		document.close();
		return oStream.toByteArray();
	}

	@Override
	public byte[] createPdfFromImage(List<byte[]> images) throws Exception {
		Document document = new Document(PageSize.LETTER, 2.5f, 2.5f, 2.5f, 2.5f);
		Rectangle letterRectangleWithMargins = new Rectangle(PageSize.LETTER.getLeft(2.5f), PageSize.LETTER.getBottom(2.5f),
				PageSize.LETTER.getRight(2.5f), PageSize.LETTER.getTop(2.5f));
		document.addAuthor(this.getClass().getCanonicalName());
		document.addCreationDate();
		document.addSubject("Manna Order Form");
		ByteArrayOutputStream ostream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, ostream);
		document.open();
		for (Iterator<byte[]> i = images.iterator(); i.hasNext();) {
			Image image = Image.getInstance(i.next());
			image.scaleAbsolute(letterRectangleWithMargins);
			 image.setAbsolutePosition(0, 0);
			document.add(image);
			if (i.hasNext())
				document.newPage();
		}
		document.close();
		return ostream.toByteArray();
	}

	public byte[] scalePdf(byte[] input, float percentage) throws DocumentException, IOException {
		ByteArrayOutputStream oStream = new ByteArrayOutputStream();
		PdfReader reader = new PdfReader(input);
		PdfStamper stamper = new PdfStamper(reader, oStream);
		int n = reader.getNumberOfPages();
		for (int p = 1; p <= n; p++) {
			float offsetX = (reader.getPageSize(p).getWidth() * (1 - percentage)) / 2;
			float offsetY = (reader.getPageSize(p).getHeight() * (1 - percentage)) / 2;
			stamper.getUnderContent(p)
					.setLiteral(String.format("\nq %s 0 0 %s %s %s cm\nq\n", percentage, percentage, offsetX, offsetY));
			stamper.getOverContent(p).setLiteral("\nQ\nQ\n");
		}
		stamper.close();
		reader.close();
		return oStream.toByteArray();
	}

}
