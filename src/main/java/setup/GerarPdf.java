package setup;

import com.github.britooo.looca.api.core.Looca;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import componentes.*;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

public class GerarPdf {
    private Looca looca;
    private Document document;
    private UsoProcessador processador;
    private MemoriaRam memoriaRam;
    private UsoDisco usoDisco;
    private Sistema sistema;
    private GrupoJanelas janelas;

    public GerarPdf() {
        looca = new Looca();
        document = new Document();
        processador = new UsoProcessador();
        memoriaRam = new MemoriaRam();
        usoDisco = new UsoDisco();
        sistema = new Sistema();
        janelas = new GrupoJanelas();
        gerarPdf();
    }

    public void gerarPdf() {
        String stringHardware = processador.toString() + memoriaRam.toString() + usoDisco.toString() + sistema.toString() + "\nJanelas consumidas pelo sistema durante o tempo de captura: \n" + janelas.toString();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(processador.getId() + ".pdf"));
            document.open();

            document.add(new Anchor("Aqui estão algumas informações básicas sobre sua máquina:"));
            document.add(new Paragraph(stringHardware));
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File(processador.getId() + ".pdf"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
