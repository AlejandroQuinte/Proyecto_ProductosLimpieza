/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccessoDatos;

import Entidades.DatosPlanilla;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element; 
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane; 

/**
 *
 * @author alequ
 */
public class ADPlantilla {
//atributos
    String nombreArchivo;
    String fecha;
    List<DatosPlanilla> compras;
    Document documento;
    FileOutputStream archivo;
    Paragraph titulo;

    //metodos
    //metodo constructor
    public void Plantilla(String nombreArchivo, String fecha, ArrayList<DatosPlanilla> compras) {
        this.nombreArchivo = nombreArchivo;
        this.fecha = fecha;
        this.compras = compras;

    }
    //Metodo para crear la planilla de compra recibiendo los datos, y usando la libreria iText 5 
    public void crearPlantilla(String nombreArchivo, String fecha, ArrayList<DatosPlanilla> compras) throws IOException {
        try {
            //Crea el documento
            documento = new Document();
            
            //Crea el archivo con el nombre enviado y dado
            archivo = new FileOutputStream(nombreArchivo + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            //se abre el documento
            documento.open();
            //Se crea la fuente para el titulo--recordar agregar la font de itext 5 
            BaseFont FuenteTitulo = BaseFont.createFont(BaseFont.HELVETICA_BOLD,BaseFont.CP1250,true) ;
            //se agrega a una nueva fuente
            Font tituloF = new Font(FuenteTitulo ,16,2);

            //Se crean los datos con la informacion de colocar, y con las fuentes que deseen colocar
            titulo = new Paragraph("Empresa Productos Limpieza CR",tituloF);
            Paragraph DireccionEmpresa = new Paragraph("Direccion: Calle 23 #2-32 Centro");
            Paragraph TelefonoEmpresa = new Paragraph("Telefono: 22888822");
            Paragraph CorreoEmpresa = new Paragraph("Correo: LimpiezaProductos@gmail.com");

            //se coloca en el centro mediante el setAlignment(1)
            CorreoEmpresa.setAlignment(1);
            TelefonoEmpresa.setAlignment(1);
            DireccionEmpresa.setAlignment(1);
            titulo.setAlignment(1);

            //se agregan los datos al documento
            documento.add(titulo );
            documento.add(DireccionEmpresa);
            documento.add(TelefonoEmpresa);
            documento.add(CorreoEmpresa);
            documento.add(Chunk.NEWLINE);

            //Agregar datos de la facturacion con la informacion recibida
            documento.add(new Paragraph("Nombre Proveedor: " + compras.get(0).getNombreProveedor()));
            //documento.add(new Paragraph("Telefono: " + compras.get(0).getNombreProveedor()));
            //documento.add(new Paragraph("Direccion: " + compras.get(0).getNombreProveedor()));
            documento.add(new Paragraph("Nombre Empleado: " + compras.get(0).getNombreEmpleado()));
            documento.add(new Paragraph("Tipo de Facturacion: Contado"));
            
            //Se crea el dato fecha 
            Paragraph fechaPDF = new Paragraph("Fecha: " + fecha);
            //se coloca en el lado izquierdo con este comando
            fechaPDF.setAlignment(2);
            //se agrega al documento
            documento.add(fechaPDF);
            //se crea un espacio o un ENTER con este comando
            documento.add(Chunk.NEWLINE);
             //se crea un espacio o un ENTER con este comando
            documento.add(Chunk.NEWLINE);

            //Se crea una tabla en el pdf
            PdfPTable tabla = new PdfPTable(6);

            //Creacion de datos Cantidad y atributos
            tabla.setWidthPercentage(100);
            PdfPCell Cantidad = new PdfPCell(new Phrase("Cantidad"));
            //se le quita el borde con este comando
            Cantidad.setBorder(0);
            //Se color al cuadro
            Cantidad.setBackgroundColor(BaseColor.LIGHT_GRAY);

            //Creacion de datos Marca y atributos
            PdfPCell marca = new PdfPCell(new Phrase("Marca"));
            //Se color al cuadro
            marca.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //se le quita el borde con este comando
            marca.setBorder(0);

            //Creacion de datos NombreProducto y atributos
            PdfPCell nombreProducto = new PdfPCell(new Phrase("Nombre Producto"));
            //Coje dos espacios para poder colocar el nombre del producto que es muy grande a veces
            nombreProducto.setColspan(2);
            //se le quita el borde con este comando
            nombreProducto.setBorder(0);
            //Se color al cuadro
            nombreProducto.setBackgroundColor(BaseColor.LIGHT_GRAY);

            //Creacion de datos PrecioProducto y atributos
            PdfPCell precioProducto = new PdfPCell(new Phrase("Valor unidad"));
            //Se color al cuadro
            precioProducto.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //se le quita el borde con este comando
            precioProducto.setBorder(0);

            //Creacion de datos PrecioTotal y atributos
            PdfPCell precioTotal = new PdfPCell(new Phrase("Valor Total"));
            //Se color al cuadro
            precioTotal.setBackgroundColor(BaseColor.LIGHT_GRAY);
            precioTotal.setBorder(0);

            //agregamos los datos a la tabla
            tabla.addCell(Cantidad);
            tabla.addCell(marca);
            tabla.addCell(nombreProducto);
            tabla.addCell(precioProducto);
            tabla.addCell(precioTotal);

            //creacion de variables que se guardan en la lectura de la tabla
            double ivaTotal, precioTotalP, subTotal = 0, Total = 0;
            String codigoCompras = "";
            for (DatosPlanilla compras1 : compras) {

                //creamos variable para guardar datos cantidad compra
                String cant = String.valueOf(compras1.getCantidadCompra());

                //hacemos la multiplicacion del producto por cantidad de producto
                precioTotalP = (compras1.getPrecioProducto() * compras1.getCantidadCompra());
                subTotal += precioTotalP;

                //Creamos los valores
                PdfPCell CantidadCompra = new PdfPCell(new Phrase(cant));
                PdfPCell MarcaProducto = new PdfPCell(new Phrase(compras1.getMarcaProducto()));
                PdfPCell NombreP = new PdfPCell(new Phrase(compras1.getNombreProducto()));
                PdfPCell PrecioProducto = new PdfPCell(new Phrase(compras1.getPrecioProducto()));
                PdfPCell PrecioTOTAL = new PdfPCell(new Phrase(String.valueOf(precioTotalP)));

                //Asignamos atributos
                //CANTIDAD
                CantidadCompra.setBorder(0);
                CantidadCompra.setVerticalAlignment(0);
                //Marca
                MarcaProducto.setBorder(0);
                MarcaProducto.setVerticalAlignment(0);
                //NOMBREPRODUCTO
                NombreP.setColspan(2);
                NombreP.setBorder(0);
                //VALORUNIDAD
                PrecioProducto.setBorder(0);
                PrecioProducto.setVerticalAlignment(0);
                //VALORTOTAL
                PrecioTOTAL.setBorder(0);
                PrecioTOTAL.setVerticalAlignment(0);

                //Creacion del codigo para pdf
                codigoCompras += compras1.getCodigo() + "";

                //Agregamos a la tabla
                tabla.addCell(CantidadCompra);
                tabla.addCell(MarcaProducto);
                tabla.addCell(NombreP);
                tabla.addCell(PrecioProducto);
                tabla.addCell(PrecioTOTAL);
            }
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);

            //Creacion de la ultima fila mostrando el  iva  con un 13% subtotal y total
            ivaTotal = subTotal / 100 * 13;
            Total = ivaTotal + subTotal;
            Paragraph SubTotalPDF = new Paragraph("SUBTOTAL $ " + subTotal);
            Paragraph IVA = new Paragraph("IVA  $    " + ivaTotal);
            Paragraph TotalPDF = new Paragraph("TOTAL $ " + Total);

            Paragraph codigo = new Paragraph(codigoCompras);
            
            //Se coloca los atributos para que quede de acuerdo a como se desee
            codigo.setAlignment(1);
            SubTotalPDF.setAlignment(2);
            IVA.setAlignment(2);
            TotalPDF.setAlignment(2);
            documento.add(SubTotalPDF);
            documento.add(IVA);
            documento.add(TotalPDF);
            documento.add(codigo);

            //se cierra el documento una vez hecho los datos o cambios
            documento.close();
            JOptionPane.showMessageDialog(null, "La facturacion se a creado correctamente!");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (DocumentException e) {
            System.err.println(e.getMessage());
        }

    }

    public void crearPlantillaVenta(String nombreArchivo, String fecha, ArrayList<DatosPlanilla> compras) throws IOException {
        try {
            documento = new Document();
             //Crea el archivo con el nombre enviado y dado
            archivo = new FileOutputStream(nombreArchivo + ".pdf");
            PdfWriter.getInstance(documento, archivo);
            //se abre el documento
            documento.open();
            //Se crea la fuente para el titulo--recordar agregar la font de itext 5 
            BaseFont FuenteTitulo = BaseFont.createFont(BaseFont.HELVETICA_BOLD,BaseFont.CP1250,true) ;
            //se agrega a una nueva fuente
            Font tituloF = new Font(FuenteTitulo ,16,2);

            //Se crean los datos con la informacion de colocar, y con las fuentes que deseen colocar
            titulo = new Paragraph("Empresa Productos Limpieza CR",tituloF);
            Paragraph DireccionEmpresa = new Paragraph("Direccion: Calle 23 #2-32 Centro");
            Paragraph TelefonoEmpresa = new Paragraph("Telefono: 22888822");
            Paragraph CorreoEmpresa = new Paragraph("Correo: LimpiezaProductos@gmail.com");

            //se coloca en el centro mediante el setAlignment(1)
            CorreoEmpresa.setAlignment(1);
            TelefonoEmpresa.setAlignment(1);
            DireccionEmpresa.setAlignment(1);
            titulo.setAlignment(1);

            //se agregan los datos al documento
            documento.add(titulo );
            documento.add(DireccionEmpresa);
            documento.add(TelefonoEmpresa);
            documento.add(CorreoEmpresa);
            documento.add(Chunk.NEWLINE);

            documento.add(new Paragraph("Nombre Cliente: " + compras.get(0).getNombreCliente()));
            //documento.add(new Paragraph("Telefono: " + compras.get(0).getNombreProveedor()));
            //documento.add(new Paragraph("Direccion: " + compras.get(0).getNombreProveedor()));
            documento.add(new Paragraph("Nombre Empleado: " + compras.get(0).getNombreEmpleado()));
            documento.add(new Paragraph("Tipo de Facturacion: Contado"));

             //Se crea el dato fecha 
            Paragraph fechaPDF = new Paragraph("Fecha: " + fecha);
            //se coloca en el lado izquierdo con este comando
            fechaPDF.setAlignment(2);
            //se agrega al documento
            documento.add(fechaPDF);
            //se crea un espacio o un ENTER con este comando
            documento.add(Chunk.NEWLINE);
             //se crea un espacio o un ENTER con este comando
            documento.add(Chunk.NEWLINE);

            //Se crea una tabla en el pdf
            PdfPTable tabla = new PdfPTable(6);

            //Creacion de datos Cantidad y atributos
            tabla.setWidthPercentage(100);
            PdfPCell Cantidad = new PdfPCell(new Phrase("Cantidad"));
            Cantidad.setBorder(0);
            Cantidad.setBackgroundColor(BaseColor.LIGHT_GRAY);

            //Creacion de datos Marca y atributos
            PdfPCell marca = new PdfPCell(new Phrase("Marca"));
            marca.setBackgroundColor(BaseColor.LIGHT_GRAY);
            marca.setBorder(0);

            //Creacion de datos NombreProducto y atributos
            PdfPCell nombreProducto = new PdfPCell(new Phrase("Nombre Producto"));
            nombreProducto.setColspan(2);
            nombreProducto.setBorder(0);
            nombreProducto.setBackgroundColor(BaseColor.LIGHT_GRAY);

            //Creacion de datos PrecioProducto y atributos
            PdfPCell precioProducto = new PdfPCell(new Phrase("Valor unidad"));
            precioProducto.setBackgroundColor(BaseColor.LIGHT_GRAY);
            precioProducto.setBorder(0);

            //Creacion de datos PrecioTotal y atributos
            PdfPCell precioTotal = new PdfPCell(new Phrase("Valor Total"));
            precioTotal.setBackgroundColor(BaseColor.LIGHT_GRAY);
            precioTotal.setBorder(0);

            //agregamos los datos a la tabla
            tabla.addCell(Cantidad);
            tabla.addCell(marca);
            tabla.addCell(nombreProducto);
            tabla.addCell(precioProducto);
            tabla.addCell(precioTotal);

            //creacion de variables que se guardan en la lectura de la tabla
            double ivaTotal, precioTotalP, subTotal = 0, Total = 0;
            String codigoCompras = "";
            for (DatosPlanilla compras1 : compras) {

                //creamos variable para guardar datos cantidad compra
                String cant = String.valueOf(compras1.getCantidadCompra());
                String PrecioP = String.valueOf(compras1.getPrecioProducto());

                //hacemos la multiplicacion del producto por cantidad de producto
                precioTotalP = (compras1.getPrecioProducto() * compras1.getCantidadCompra());
                subTotal += precioTotalP;

                //Creamos los valores
                PdfPCell CantidadPro = new PdfPCell(new Phrase(cant));
                PdfPCell MarcaProducto = new PdfPCell(new Phrase(compras1.getMarcaProducto()));
                PdfPCell NombreP = new PdfPCell(new Phrase(compras1.getNombreProducto()));
                PdfPCell PrecioProducto = new PdfPCell(new Phrase(PrecioP));
                PdfPCell PrecioTOTAL = new PdfPCell(new Phrase(String.valueOf(precioTotalP)));

                //Asignamos atributos
                //CANTIDAD
                CantidadPro.setBorder(0);
                CantidadPro.setVerticalAlignment(0);
                //Marca
                MarcaProducto.setBorder(0);
                MarcaProducto.setVerticalAlignment(0);
                //NOMBREPRODUCTO
                NombreP.setColspan(2);
                NombreP.setBorder(0);
                //VALORUNIDAD
                PrecioProducto.setBorder(0);
                PrecioProducto.setVerticalAlignment(0);
                //VALORTOTAL
                PrecioTOTAL.setBorder(0);
                PrecioTOTAL.setVerticalAlignment(0);

                //Creacion del codigo para pdf
                codigoCompras += compras1.getCodigo() + "";

                //Agregamos a la tabla
                tabla.addCell(CantidadPro);
                tabla.addCell(MarcaProducto);
                tabla.addCell(NombreP);
                tabla.addCell(PrecioProducto);
                tabla.addCell(PrecioTOTAL);
            }
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);

             //Creacion de la ultima fila mostrando el  iva  con un 13% subtotal y total
            ivaTotal = subTotal / 100 * 13;
            Total = ivaTotal + subTotal;
            Paragraph SubTotalPDF = new Paragraph("SUBTOTAL $ " + subTotal);
            Paragraph IVA = new Paragraph("IVA  $    " + ivaTotal);
            Paragraph TotalPDF = new Paragraph("TOTAL $ " + Total);

            Paragraph codigo = new Paragraph(codigoCompras);
            
            //Se coloca los atributos para que quede de acuerdo a como se desee
            codigo.setAlignment(1);
            SubTotalPDF.setAlignment(2);
            IVA.setAlignment(2);
            TotalPDF.setAlignment(2);
            documento.add(SubTotalPDF);
            documento.add(IVA);
            documento.add(TotalPDF);
            documento.add(codigo);

            //se cierra el documento una vez hecho los datos o cambios
            documento.close();
            JOptionPane.showMessageDialog(null, "La facturacion se a creado correctamente!");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (DocumentException e) {
            System.err.println(e.getMessage());
        }

    }

}
