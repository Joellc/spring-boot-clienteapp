package com.springboot.clienteapp.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springboot.clienteapp.models.entity.Cliente;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/views/clientes/listar")
public class ListarClientesPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Cliente> listadoClientes = (List<Cliente>) model.get("clientes");
		
		document.setPageSize(PageSize.LETTER.rotate());
		document.setMargins(-30,-30, 40, 30);
		document.open();
		
		PdfPTable tablaTitulo = new PdfPTable(1);
		PdfPCell celda = null;
		
		Font fuenteTitulo = FontFactory.getFont("Helvetica",16,Color.BLUE);
		Font fuenteTituloColumnas = FontFactory.getFont("Arial",16,Color.BLACK);
		
		celda = new PdfPCell(new Phrase("LISTADO GENERAL DEL CLIENTES", fuenteTitulo));
		celda.setBorder(0);
		celda.setBackgroundColor(new Color(255,221,51));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(25);
		
		tablaTitulo.addCell(celda);
		tablaTitulo.setSpacingAfter(30);
		
		PdfPTable tablaClientes = new PdfPTable(6);
		tablaClientes.setWidths(new float[] {0.8f, 2f, 2f, 1.9f, 3.5f, 1.7f});
		
		
		celda = new PdfPCell(new Phrase("ID", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(236, 234, 224));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("NOMBRE", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(236, 234, 224));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("APELLIDO", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(236, 234, 224));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("TELEFONO", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(236, 234, 224));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("EMAIL", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(236, 234, 224));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		celda = new PdfPCell(new Phrase("CIUDAD", fuenteTituloColumnas));
		celda.setBackgroundColor(new Color(236, 234, 224));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPadding(10);
		tablaClientes.addCell(celda);
		
		for(Cliente cliente : listadoClientes) {
			celda = new PdfPCell(new Phrase(cliente.getId().toString(),fuenteTituloColumnas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getNombres(),fuenteTituloColumnas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getApellidos(),fuenteTituloColumnas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getTelefono(),fuenteTituloColumnas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getEmail(),fuenteTituloColumnas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			celda = new PdfPCell(new Phrase(cliente.getCiudad().getCiudad(),fuenteTituloColumnas));
			celda.setPadding(5);
			tablaClientes.addCell(celda);
			
			
			
		}
				
			
		/*
		tablaClientes.addCell(celda);
		listadoClientes.forEach(cliente ->{
			tablaClientes.addCell(cliente.getId().toString());
			tablaClientes.addCell(cliente.getNombres());
			tablaClientes.addCell(cliente.getApellidos());
			tablaClientes.addCell(cliente.getTelefono());
			tablaClientes.addCell(cliente.getEmail());
			tablaClientes.addCell(cliente.getCiudad().getCiudad());
		
		
		});*/
		document.add(tablaTitulo);
		document.add(tablaClientes);
	}
}
