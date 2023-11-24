package Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;
	
import Dao.Conexion;

public class Reporte {

	
	public static void ReportesUsuario() {
		
		Document documento = new Document();
		documento.setPageSize(new Rectangle(710, documento.getPageSize().getHeight()));
		try {
			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes Usuarios.pdf"));
			Image header = Image.getInstance("src/main/resources/Img/banner1 ferreteria.png");
			header.scaleToFit(730,980);
			header.setAlignment(Chunk.ALIGN_CENTER);
				
	
			
			Paragraph parrafo = new Paragraph();
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.setFont(FontFactory.getFont("Arial", 13, Font.ITALIC,BaseColor.DARK_GRAY));
			parrafo.add("Reporte generado por Ferreteria ToolsNest © F.T.N  \n\n\n\n\n\n");
			parrafo.setFont(FontFactory.getFont("Bahnschrift SemiBold", 28, Font.BOLD,BaseColor.BLACK));
			parrafo.add("Reporte de Usuarios \n\n\n");
			
			documento.open();
			
			documento.add(header);
			documento.add(parrafo);
			
			float[] columnsWidths = {4, 5, 6, 10, 8};
			PdfPTable tabla = new PdfPTable(columnsWidths);
			
			tabla.addCell("Codigo");
			tabla.addCell("Nombre");
			tabla.addCell("N° DNI");
			tabla.addCell("Correo");
			tabla.addCell("Telefono");
			
			try {
				Connection cn = Conexion.obtenerConexion();
				PreparedStatement pst = cn.prepareStatement(
						"SELECT u.id, u.dni_empleado, u.nombre, r.descripcion as rol_nombre, " +
			                    "CASE WHEN u.estado = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END as estado_nombre " +
			                    "FROM usuario u " +
			                    "JOIN rol r ON u.rol = r.id"
						);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					do {
						tabla.addCell(rs.getString(1));
						tabla.addCell(rs.getString(2));
						tabla.addCell(rs.getString(3));
						tabla.addCell(rs.getString(4));
						tabla.addCell(rs.getString(5));
						
						
					} while (rs.next());
					documento.add(tabla);
					
					JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error en " + e);
			}
			documento.close();
			
		} catch (DocumentException | IOException e) {
			// TODO: handle exception
			System.out.println("Error en: " +e);
		}
		//documento.close();
	}
	
public static void ReportesProveedores() {

		
		Document documento = new Document();
		
		documento.setPageSize(new Rectangle(830, documento.getPageSize().getHeight()));
		
		try {
			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes Proveedores.pdf"));
			
			//FooterPageEvent event = new FooterPageEvent();
			//writer.setPageEvent(event);
			
			Image header = Image.getInstance("src/main/resources/Img/banner1 ferreteria.png");
			header.scaleToFit(840,1000);
			header.setAlignment(Chunk.ALIGN_CENTER);
				
			//Formato Text
			
			Paragraph parrafo = new Paragraph();
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.setFont(FontFactory.getFont("Arial", 13, Font.ITALIC,BaseColor.DARK_GRAY));
			parrafo.add("Reporte generado por Ferreteria ToolsNest © F.T.N \n\n\n\n\n\n");
			parrafo.setFont(FontFactory.getFont("Bahnschrift SemiBold", 28, Font.BOLD,BaseColor.BLACK));
			parrafo.add("Reporte de Proveedores \n\n\n");
			
			documento.open();
			
			documento.add(header);
			documento.add(parrafo);
			
			float[] columnsWidths = {5, 9, 7, 12, 7, 5};

			PdfPTable tabla = new PdfPTable(columnsWidths);
			PdfPCell cell = new PdfPCell();
			cell.setBorderWidth(2f);
			
			
			tabla.addCell("Codigo");
			tabla.addCell("Razón Social");
			tabla.addCell("Telefono");
			tabla.addCell("Dirección");
			tabla.addCell("Correo");
			tabla.addCell("Estado");
		

			
			try {
				Connection cn = Conexion.obtenerConexion();
				PreparedStatement pst = cn.prepareStatement("SELECT p.id, p.razon_social, p.telefono, p.direccion, p.correo, " +
	                    "CASE WHEN p.estado = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END as estado_nombre " +
	                    "FROM proveedor p");
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					do {
						tabla.addCell(rs.getString(1));
						tabla.addCell(rs.getString(2));
						tabla.addCell(rs.getString(3));
						tabla.addCell(rs.getString(4));
						tabla.addCell(rs.getString(5));
						tabla.addCell(rs.getString(6));
					//	tabla.addCell(rs.getString(7));
									
			
					} while (rs.next());
					documento.add(tabla);
					
					JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error en " + e);
			}
			documento.close();
			
		} catch (DocumentException | IOException e) {
			// TODO: handle exception
			System.out.println("Error en: " +e);
		}
		//documento.close();
	}

public class FooterPageEvent implements PdfPageEvent {
    public void onOpenDocument(PdfWriter writer, Document document) {}

    public void onStartPage(PdfWriter writer, Document document) {}

    public void onEndPage(PdfWriter writer, Document document) {
        Phrase footer = new Phrase("Reporte generado por Ferreteria ToolsNest © F.T.N", FontFactory.getFont("Arial", 15, Font.ITALIC));
        float x = (document.left() + document.right()) / 2;
        float y = document.bottom() - 10;
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, footer, x, y, 0);
    }
    
    

	@Override
	public void onChapter(PdfWriter arg0, Document arg1, float arg2, Paragraph arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChapterEnd(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCloseDocument(PdfWriter arg0, Document arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGenericTag(PdfWriter arg0, Document arg1, Rectangle arg2, String arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParagraph(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onParagraphEnd(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSection(PdfWriter arg0, Document arg1, float arg2, int arg3, Paragraph arg4) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSectionEnd(PdfWriter arg0, Document arg1, float arg2) {
		// TODO Auto-generated method stub
		
	}

}


public static void ReportesClientes() {

	
	Document documento = new Document();
	
	
	documento.setPageSize(new Rectangle(830, documento.getPageSize().getHeight()));
	
	try {
		String ruta = System.getProperty("user.home");
		PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reportes Clientes.pdf"));
		
		
		Image header = Image.getInstance("src/main/resources/Img/banner1 ferreteria.png");
		header.scaleToFit(840,1000);
		header.setAlignment(Chunk.ALIGN_CENTER);
			
		//Formato Text
		
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		parrafo.setFont(FontFactory.getFont("Arial", 13, Font.ITALIC,BaseColor.DARK_GRAY));
		parrafo.add("Reporte generado por Ferreteria ToolsNest © F.T.N \n\n\n\n\n\n");
		parrafo.setFont(FontFactory.getFont("Bahnschrift SemiBold", 28, Font.BOLD,BaseColor.BLACK));
		parrafo.add("Reporte de Clientes \n\n\n");
		
		documento.open();
		
		documento.add(header);
		documento.add(parrafo);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorderWidth(2f);
		float[] columnsWidths = {4, 5, 7, 10, 8};

		PdfPTable tabla = new PdfPTable(columnsWidths);
		
		
		tabla.addCell("Codigo");
		tabla.addCell("N° DNI");
		tabla.addCell("Nombre");
		tabla.addCell("Correo");
		tabla.addCell("Telefono");
				
		
		try {
			Connection cn = Conexion.obtenerConexion();
			PreparedStatement pst = cn.prepareStatement(
					"SELECT id, dni, nombres, correo, telefono FROM cliente"
					);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				do {
					tabla.addCell(rs.getString(1));
					tabla.addCell(rs.getString(2));
					tabla.addCell(rs.getString(3));
					tabla.addCell(rs.getString(4));
					tabla.addCell(rs.getString(5));
					
					
				} while (rs.next());
				documento.add(tabla);
				
				JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en " + e);
		}
		documento.close();
		
	} catch (DocumentException | IOException e) {
		// TODO: handle exception
		System.out.println("Error en: " +e);
	}
	//documento.close();
}

public static void ReporteEmpleado() {

	
	Document documento = new Document();
	
	documento.setPageSize(new Rectangle(830, documento.getPageSize().getHeight()));
	
	try {
		String ruta = System.getProperty("user.home");
		PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte Empleados.pdf"));
		
		//FooterPageEvent event = new FooterPageEvent();
		//writer.setPageEvent(event);
		
		Image header = Image.getInstance("src/main/resources/Img/banner1 ferreteria.png");
		header.scaleToFit(840,1000);
		header.setAlignment(Chunk.ALIGN_CENTER);
			
		//Formato Text
		
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		parrafo.setFont(FontFactory.getFont("Arial", 13, Font.ITALIC,BaseColor.DARK_GRAY));
		parrafo.add("Reporte generado por Ferreteria ToolsNest © F.T.N \n\n\n\n\n\n");
		parrafo.setFont(FontFactory.getFont("Bahnschrift SemiBold", 28, Font.BOLD,BaseColor.BLACK));
		parrafo.add("Reporte de Empleados \n\n\n");
		
		documento.open();
		
		documento.add(header);
		documento.add(parrafo);
		
		PdfPCell cell = new PdfPCell();
		cell.setBorderWidth(2f);
		float[] columnsWidths = {9, 16, 30, 35, 30, 15, 14};

		PdfPTable tabla = new PdfPTable(columnsWidths);
		
		
		tabla.addCell("Código");
		tabla.addCell("DNI");
		tabla.addCell("Nombre");
		tabla.addCell("Correo");
		tabla.addCell("Dirección");
		tabla.addCell("Cargo");
		tabla.addCell("Estado");
		
		
		
		try {
			Connection cn = Conexion.obtenerConexion();
			PreparedStatement pst = cn.prepareStatement("SELECT e.id, e.dni, e.nombres, e.correo, e.direccion, c.descripcion AS cargo, " +
                    "CASE WHEN e.estado = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END AS estado_nombre " +
                    "FROM empleado e " +
                    "JOIN cargo c ON e.id_cargo = c.id");
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				do {
					tabla.addCell(rs.getString(1));
					tabla.addCell(rs.getString(2));
					tabla.addCell(rs.getString(3));
					tabla.addCell(rs.getString(4));
					tabla.addCell(rs.getString(5));
					tabla.addCell(rs.getString(6));
					tabla.addCell(rs.getString(7));
					
					
				} while (rs.next());
				documento.add(tabla);
				
				JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en " + e);
		}
		documento.close();
		
	} catch (DocumentException | IOException e) {
		// TODO: handle exception
		System.out.println("Error en: " +e);
	}
	//documento.close();
}

public static void ReporteVentas() {

    Document document = new Document();

    document.setPageSize(new Rectangle(830, document.getPageSize().getHeight()));

    try {
        String ruta = System.getProperty("user.home");
        PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Reporte Ventas.pdf"));

        Image header = Image.getInstance("src/main/resources/Img/banner1 ferreteria.png");
        header.scaleToFit(840, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        Paragraph parrafo = new Paragraph();
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);
        parrafo.setFont(FontFactory.getFont("Arial", 13, Font.ITALIC, BaseColor.DARK_GRAY));
        parrafo.add("Reporte generado por Ferreteria ToolsNest © F.T.N \n\n\n\n\n\n");
        parrafo.setFont(FontFactory.getFont("Bahnschrift SemiBold", 28, Font.BOLD, BaseColor.BLACK));
        parrafo.add("Reporte de Ventas \n\n\n");

        document.open();

        document.add(header);
        document.add(parrafo);

        float[] columnsWidths = {5, 12, 9, 7, 7, 7, 9, 5};

        PdfPTable tabla = new PdfPTable(columnsWidths);
        PdfPCell cell = new PdfPCell();
        cell.setBorderWidth(2f);

        tabla.addCell("ID");
        tabla.addCell("Número Venta");
        tabla.addCell("ID Cliente");
        tabla.addCell("Total");
        tabla.addCell("ID Modo Pago");
        tabla.addCell("ID Empleado");
        tabla.addCell("Fecha Venta");
        tabla.addCell("Estado");

        try {
            Connection cn = Conexion.obtenerConexion();
            PreparedStatement pst = cn.prepareStatement(
                    "SELECT v.id, v.numero_venta, v.id_cliente, v.total, m.descripcion AS modo_pago, e.nombres AS empleado, " +
                            "v.fecha_registro, CASE WHEN v.estado = 1 THEN 'ACTIVO' ELSE 'INACTIVO' END as estado_nombre " +
                            "FROM venta v " +
                            "JOIN modo_pago m ON v.id_modo_pago = m.id " +
                            "JOIN empleado e ON v.id_empleado = e.id");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                do {
                    tabla.addCell(rs.getString(1));
                    tabla.addCell(rs.getString(2));
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(4));
                    tabla.addCell(rs.getString(5)); // Nombre del modo_pago
                    tabla.addCell(rs.getString(6)); // Nombre del empleado
                    tabla.addCell(rs.getString(7));
                    tabla.addCell(rs.getString(8));

                } while (rs.next());
                document.add(tabla);

                JOptionPane.showMessageDialog(null, "Reporte de Ventas creado exitosamente");

            }

        } catch (SQLException e) {
            System.out.println("Error en " + e);
        }
        document.close();

    } catch (DocumentException | IOException e) {
        System.out.println("Error en: " + e);
    }
}



}

