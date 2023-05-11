
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CrearArchivoVehiculos {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		File archivo=new File("vehiculos.exp");
		
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(archivo));
		SimpleDateFormat fecha=new SimpleDateFormat("dd/MM/yyyy");
		oos.writeObject(new Vehiculo("6574FDU","OPEL INSIGNIA",15500,fecha.parse("01/05/2022")));
		oos.writeObject(new Vehiculo("8584DDZ", "CITROEN C3",9800,fecha.parse("02/05/2022")));
		oos.writeObject(new Vehiculo("5874FGM", "OPEL ASTRA",11000,fecha.parse("02/05/2022")));
		oos.writeObject(new Vehiculo("9984HET","MERCEDES C270",9500,fecha.parse("04/05/2022")));
		oos.writeObject(new Vehiculo("1254BNG","BMW X3",15800,fecha.parse("06/05/2022")));
		oos.writeObject(new Vehiculo("0934GXY","NISSAN QASHQAI2 2.0",12800,fecha.parse("07/05/2022")));
		
		
		oos.close();
		

	}

}
