package br.com.leguimas.kartero.parser;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import br.com.leguimas.kartero.importer.entity.Localidade;
import br.com.leguimas.kartero.importer.parser.CorreiosParser;

public class ParserTest {

    @Test
    public void testParser() {
        String basePath = "./src/test/resources/baseExemplo/base_eDNE/Basico/Delimitado";

        CorreiosParser parser = new CorreiosParser();
        parser.parseFiles(basePath);

        assertLocalidades(parser);
    }

    private void assertLocalidades(CorreiosParser parser) {
        List<Localidade> localidades = parser.getLocalidades();
        assertNotNull(localidades);
        assertEquals(6, localidades.size());

        Localidade loc = localidades.get(0);
        assertEquals(1, (int) loc.getLocNu());
        assertEquals("AC", loc.getUfeSg());
        assertEquals("Acrel�ndia", loc.getLocNo());
        assertEquals("69945000", loc.getCep());
        assertEquals('0', (char) loc.getLocInSit());
        assertEquals('M', (char) loc.getLocInTipoLoc());
        assertNull(loc.getLocNuSub());
        assertEquals("Acrel�ndia", loc.getLocNoAbrev());
        assertEquals("1200013", loc.getMunNu());

        loc = localidades.get(1);
        assertEquals(15, (int) loc.getLocNu());
        assertEquals("AC", loc.getUfeSg());
        assertEquals("Porto Walter", loc.getLocNo());
        assertEquals("69982000", loc.getCep());
        assertEquals('0', (char) loc.getLocInSit());
        assertEquals('M', (char) loc.getLocInTipoLoc());
        assertNull(loc.getLocNuSub());
        assertEquals("Pto Walter", loc.getLocNoAbrev());
        assertEquals("1200393", loc.getMunNu());

        loc = localidades.get(2);
        assertEquals(16, (int) loc.getLocNu());
        assertEquals("AC", loc.getUfeSg());
        assertEquals("Rio Branco", loc.getLocNo());
        assertNull(loc.getCep());
        assertEquals('1', (char) loc.getLocInSit());
        assertEquals('M', (char) loc.getLocInTipoLoc());
        assertNull(loc.getLocNuSub());
        assertEquals("Rio Branco", loc.getLocNoAbrev());
        assertEquals("1200401", loc.getMunNu());

        loc = localidades.get(3);
        assertEquals(1778, (int) loc.getLocNu());
        assertEquals("DF", loc.getUfeSg());
        assertEquals("Bras�lia", loc.getLocNo());
        assertNull(loc.getCep());
        assertEquals('1', (char) loc.getLocInSit());
        assertEquals('M', (char) loc.getLocInTipoLoc());
        assertNull(loc.getLocNuSub());
        assertEquals("Bras�lia", loc.getLocNoAbrev());
        assertEquals("5300108", loc.getMunNu());

        loc = localidades.get(4);
        assertEquals(1811, (int) loc.getLocNu());
        assertEquals("ES", loc.getUfeSg());
        assertEquals("�ngelo Frechiani", loc.getLocNo());
        assertNull(loc.getCep());
        assertEquals('2', (char) loc.getLocInSit());
        assertEquals('D', (char) loc.getLocInTipoLoc());
        assertEquals(1847, (int) loc.getLocNuSub());
        assertEquals("�ngelo Frechiani", loc.getLocNoAbrev());
        assertNull(loc.getMunNu());

        loc = localidades.get(5);
        assertEquals(1847, (int) loc.getLocNu());
        assertEquals("ES", loc.getUfeSg());
        assertEquals("Colatina", loc.getLocNo());
        assertNull(loc.getCep());
        assertEquals('1', (char) loc.getLocInSit());
        assertEquals('M', (char) loc.getLocInTipoLoc());
        assertNull(loc.getLocNuSub());
        assertEquals("Colatina", loc.getLocNoAbrev());
        assertEquals("3201506", loc.getMunNu());
    }
}