package Project_2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.jena.ontology.DatatypeProperty;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntResource;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.iterator.ExtendedIterator;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.vocabulary.XSD;
public class Main 
{
	public static void main(String[] args) throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(Paths.get("filename.txt"));
		writer.write("");
		writer.flush();
		
		// some definitions
		String baseUri = "http://www.semanticweb.org/mohamedatta/ontologies/2021/11/untitled-ontology-35#";
		// create an empty Model
		OntModel  model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM );
		OntClass CityClass = model.createClass( baseUri + "City" );
		OntClass StopClass = model.createClass( baseUri + "Stop" );
		OntClass StopAreaClass = model.createClass( baseUri + "StopArea" );
		OntClass StopPointClass = model.createClass( baseUri + "StopPoint" );
		OntClass RouteClass = model.createClass( baseUri + "Route" );
		OntClass Stop_TimeClass = model.createClass( baseUri + "Stop_Time" );
		OntClass TransferClass = model.createClass( baseUri + "Transfer" );
		model.add(StopPointClass,RDFS.subClassOf,StopClass);
		model.add(StopAreaClass,RDFS.subClassOf,StopClass);
		

		ObjectProperty hasStopArea = model.createObjectProperty( baseUri + "hasStopArea" );
		ObjectProperty hasStopPoints = model.createObjectProperty( baseUri + "hasStopPoints" );
		ObjectProperty ToStopPoint = model.createObjectProperty( baseUri + "To" );

		hasStopArea.addDomain(CityClass);
		hasStopArea.addRange(StopAreaClass);
		
		hasStopPoints.addDomain(StopAreaClass);
		hasStopPoints.addRange(StopPointClass);
		
		ToStopPoint.addDomain(StopPointClass);
		ToStopPoint.addRange(StopPointClass);


		/////// dataProperties
		
		////Stop_times
		DatatypeProperty trip_id = model.createDatatypeProperty( baseUri + "trip_id" );
		trip_id.addDomain( Stop_TimeClass );
		trip_id.addRange( XSD.xstring );

		DatatypeProperty arrival_time = model.createDatatypeProperty( baseUri + "arrival_time" );
		arrival_time.addDomain( Stop_TimeClass );
		arrival_time.addRange( XSD.time );

		DatatypeProperty departure_time = model.createDatatypeProperty( baseUri + "departure_time" );
		departure_time.addDomain( Stop_TimeClass );
		departure_time.addRange( XSD.time);
		
		
		DatatypeProperty stop_sequence = model.createDatatypeProperty( baseUri + "stop_sequence" );
		stop_sequence.addDomain( Stop_TimeClass );
		stop_sequence.addRange( XSD.xstring);
		
		DatatypeProperty stop_headsign = model.createDatatypeProperty( baseUri + "stop_headsign" );
		stop_sequence.addDomain( Stop_TimeClass );
		stop_sequence.addRange( XSD.xstring);
		
		DatatypeProperty pickup_type = model.createDatatypeProperty( baseUri + "pickup_type" );
		pickup_type.addDomain( Stop_TimeClass );
		pickup_type.addRange( XSD.xstring);

		DatatypeProperty drop_off_type = model.createDatatypeProperty( baseUri + "drop_off_type" );
		drop_off_type.addDomain( Stop_TimeClass );
		drop_off_type.addRange( XSD.xstring);
		
		DatatypeProperty shape_dist_traveled = model.createDatatypeProperty( baseUri + "shape_dist_traveled" );
		shape_dist_traveled.addDomain( Stop_TimeClass );
		shape_dist_traveled.addRange( XSD.xstring);
		
		
		////Stops
		DatatypeProperty stop_id = model.createDatatypeProperty( baseUri + "stop_id" );
		stop_id.addDomain( StopPointClass );
		stop_id.addRange( XSD.xstring );
		stop_id.addDomain( StopAreaClass );
		stop_id.addRange( XSD.xstring );
		
		DatatypeProperty stop_name = model.createDatatypeProperty( baseUri + "stop_name" );
		stop_name.addDomain( StopAreaClass );
		stop_name.addRange( XSD.xstring );
		stop_name.addDomain( StopPointClass );
		stop_name.addRange( XSD.xstring );
		
		DatatypeProperty stop_desc = model.createDatatypeProperty( baseUri + "stop_desc" );
		stop_desc.addDomain( StopAreaClass );
		stop_desc.addRange( XSD.xstring );
		stop_desc.addDomain( StopPointClass );
		stop_desc.addRange( XSD.xstring );
		
		DatatypeProperty stop_lat = model.createDatatypeProperty( baseUri + "stop_lat" );
		stop_lat.addDomain( StopAreaClass );
		stop_lat.addRange( XSD.xfloat );
		stop_lat.addDomain( StopPointClass );
		stop_lat.addRange( XSD.xfloat );
		
		DatatypeProperty stop_lon = model.createDatatypeProperty( baseUri + "stop_lon" );
		stop_lon.addDomain( StopAreaClass );
		stop_lon.addRange( XSD.xfloat );
		stop_lon.addDomain( StopPointClass );
		stop_lon.addRange( XSD.xfloat );
		
		DatatypeProperty zone_id = model.createDatatypeProperty( baseUri + "zone_id" );
		zone_id.addDomain( StopAreaClass );
		zone_id.addRange( XSD.xstring );
		zone_id.addDomain( StopPointClass );
		zone_id.addRange( XSD.xstring );
		
		DatatypeProperty stop_url = model.createDatatypeProperty( baseUri + "stop_url" );
		stop_url.addDomain( StopAreaClass );
		stop_url.addRange( XSD.xstring );
		stop_url.addDomain( StopPointClass );
		stop_url.addRange( XSD.xstring );
		
		DatatypeProperty location_type = model.createDatatypeProperty( baseUri + "location_type" );
		location_type.addDomain( StopAreaClass );
		location_type.addRange( XSD.xstring );
		location_type.addDomain( StopPointClass );
		location_type.addRange( XSD.xstring );
		
		DatatypeProperty parent_station = model.createDatatypeProperty( baseUri + "parent_station" );
		parent_station.addDomain( StopAreaClass );
		parent_station.addRange( XSD.xstring );
		parent_station.addDomain( StopPointClass );
		parent_station.addRange( XSD.xstring );
		
		DatatypeProperty stop_timezone_header = model.createDatatypeProperty( baseUri + "stop_timezone_header" );
		stop_timezone_header.addDomain( StopAreaClass );
		stop_timezone_header.addRange( XSD.xstring );
		stop_timezone_header.addDomain( StopPointClass );
		stop_timezone_header.addRange( XSD.xstring );
		
		////Transfers
		DatatypeProperty from_stop_id = model.createDatatypeProperty( baseUri + "from_stop_id" );
		from_stop_id.addDomain( TransferClass );
		from_stop_id.addRange( XSD.xstring );
		
		DatatypeProperty to_stop_id = model.createDatatypeProperty( baseUri + "to_stop_id" );
		to_stop_id.addDomain( TransferClass );
		to_stop_id.addRange( XSD.xstring );
		
		DatatypeProperty transfer_type = model.createDatatypeProperty( baseUri + "transfer_type" );
		transfer_type.addDomain( TransferClass );
		transfer_type.addRange( XSD.xstring );
		
		DatatypeProperty min_transfer_time = model.createDatatypeProperty( baseUri + "min_transfer_time" );
		min_transfer_time.addDomain( TransferClass );
		min_transfer_time.addRange( XSD.time );
		
		DatatypeProperty from_route_id = model.createDatatypeProperty( baseUri + "from_route_id" );
		from_route_id.addDomain( TransferClass );
		from_route_id.addRange( XSD.xstring );
		
		DatatypeProperty to_route_id = model.createDatatypeProperty( baseUri + "to_route_id" );
		to_route_id.addDomain( TransferClass );
		to_route_id.addRange( XSD.xstring );
		
		////Routes
		DatatypeProperty route_id = model.createDatatypeProperty( baseUri + "route_id" );
		route_id.addDomain( RouteClass );
		route_id.addRange( XSD.xstring );
		
		DatatypeProperty agency_id = model.createDatatypeProperty( baseUri + "agency_id" );
		agency_id.addDomain( RouteClass );
		agency_id.addRange( XSD.xstring );
		
		DatatypeProperty route_short_name = model.createDatatypeProperty( baseUri + "route_short_name" );
		route_short_name.addDomain( RouteClass );
		route_short_name.addRange( XSD.xstring );
		
		DatatypeProperty route_long_name = model.createDatatypeProperty( baseUri + "route_long_name" );
		route_long_name.addDomain( RouteClass );
		route_long_name.addRange( XSD.xstring );
		
		DatatypeProperty route_desc = model.createDatatypeProperty( baseUri + "route_desc" );
		route_desc.addDomain( RouteClass );
		route_desc.addRange( XSD.xstring );
		
		DatatypeProperty route_type = model.createDatatypeProperty( baseUri + "route_type" );
		route_type.addDomain( RouteClass );
		route_type.addRange( XSD.xstring );
		
		DatatypeProperty route_url = model.createDatatypeProperty( baseUri + "route_url" );
		route_url.addDomain( RouteClass );
		route_url.addRange( XSD.xstring );
		
		DatatypeProperty route_color = model.createDatatypeProperty( baseUri + "route_color" );
		route_color.addDomain( RouteClass );
		route_color.addRange( XSD.xstring );
		
		DatatypeProperty route_text_color = model.createDatatypeProperty( baseUri + "route_text_color" );
		route_text_color.addDomain( RouteClass );
		route_text_color.addRange( XSD.xstring );
		
		////Cities
		DatatypeProperty CityName = model.createDatatypeProperty( baseUri + "CityName" );
		CityName.addDomain( CityClass );
		CityName.addRange( XSD.xstring );
		
		DatatypeProperty CityLat = model.createDatatypeProperty( baseUri + "CityLat" );
		CityLat.addDomain( CityClass );
		CityLat.addRange( XSD.xdouble );
		
		DatatypeProperty CityLong = model.createDatatypeProperty( baseUri + "CityLong" );
		CityLong.addDomain( CityClass );
		CityLong.addRange( XSD.xdouble );

		/// creating Individuals
		
		BufferedReader objReader1 = new BufferedReader(new FileReader("cities.txt"));
		String strCurrentLine1;
		int i1=0;
		while ((strCurrentLine1 = objReader1.readLine()) != null) {
		    i1++;
		    Individual s = CityClass.createIndividual(baseUri+"City_Individual_"+i1);
		    ArrayList <String> data = split(strCurrentLine1);
		    String x=data.get(0);
		    x=x.substring(x.lastIndexOf("/")+1);
		    data.set(0, x);
		    s.addProperty(CityName, data.get(0));
		    s.addProperty(CityLat, data.get(1));
		    s.addProperty(CityLong, data.get(2));
		}
		
		
		BufferedReader objReader2 = new BufferedReader(new FileReader("Transfers.txt"));
		String strCurrentLine2;
		int i2=0;
		while ((strCurrentLine2 = objReader2.readLine()) != null) {
			i2++;
		    Individual s = TransferClass.createIndividual(baseUri+"Transfer_Individual_"+i2);
		    ArrayList <String> data = split(strCurrentLine2);
		    s.addProperty(from_stop_id, data.get(0));
		    s.addProperty(to_stop_id, data.get(1));
		    s.addProperty(transfer_type, data.get(2));
		    s.addProperty(min_transfer_time, data.get(3));
		    s.addProperty(from_route_id, data.get(4));
		    s.addProperty(to_route_id, data.get(5));
		}
		
		
		BufferedReader objReader3 = new BufferedReader(new FileReader("Routes.txt"));
		String strCurrentLine3;
		int i3=0;
		while ((strCurrentLine3 = objReader3.readLine()) != null) {
		    i3++;
		    Individual s = RouteClass.createIndividual(baseUri+"Route_Individual_"+i3);
		    ArrayList <String> data = split(strCurrentLine3);
		    s.addProperty(route_id, data.get(0));
		    s.addProperty(agency_id, data.get(1));
		    s.addProperty(route_short_name, data.get(2));
		    s.addProperty(route_long_name, data.get(3));
		    s.addProperty(route_desc, data.get(4));
		    s.addProperty(route_type, data.get(5));
		    s.addProperty(route_url, data.get(6));
		    s.addProperty(route_color, data.get(7));
		    s.addProperty(route_text_color, data.get(8));
		}
		
		
		BufferedReader objReader4 = new BufferedReader(new FileReader("Stops.txt"));
		String strCurrentLine4;
		int i4=0;
		while ((strCurrentLine4 = objReader4.readLine()) != null) {
		    
		    i4++;
		    ArrayList <String> data = split(strCurrentLine4);
		    if(data.get(0).contains("StopArea")) 
		    {
		    	Individual s = StopAreaClass.createIndividual(baseUri+"Stop_Area_Individual_"+i4);
		    	s.addProperty(stop_id, data.get(0));
		    	s.addProperty(stop_name, data.get(1));
			    s.addProperty(stop_desc, data.get(2));
			    s.addProperty(stop_lat, data.get(3));
			    s.addProperty(stop_lon, data.get(4));
			    s.addProperty(zone_id, data.get(5));
			    s.addProperty(stop_url, data.get(6));
			    s.addProperty(location_type, data.get(7));
			    s.addProperty(parent_station, data.get(8));
			    s.addProperty(stop_timezone_header, data.get(9));
		    }
		    else if(data.get(0).contains("StopPoint")) 
		    {
		    	Individual s = StopPointClass.createIndividual(baseUri+"Stop_Point_Individual_"+i4);
		    	s.addProperty(stop_id, data.get(0));
		    	s.addProperty(stop_name, data.get(1));
			    s.addProperty(stop_desc, data.get(2));
			    s.addProperty(stop_lat, data.get(3));
			    s.addProperty(stop_lon, data.get(4));
			    s.addProperty(zone_id, data.get(5));
			    s.addProperty(stop_url, data.get(6));
			    s.addProperty(location_type, data.get(7));
			    s.addProperty(parent_station, data.get(8));
			    s.addProperty(stop_timezone_header, data.get(9));
		    }
		}
		
	
		
		ExtendedIterator<? extends OntResource> x =StopPointClass.listInstances();
		while(x.hasNext()) 
		{
			ExtendedIterator<? extends OntResource> y =StopAreaClass.listInstances();
			OntResource area_resource=x.next();
			String area=area_resource.getProperty(parent_station).getString();
			while(y.hasNext()) 
			{
				OntResource resource=y.next();
				if(resource.getProperty(stop_id).getString().equals(area)) 
				{
					resource.addProperty(hasStopPoints, area_resource);
				}
			}
			
		}
		ExtendedIterator<? extends OntResource> x1 =StopAreaClass.listInstances();
		while(x1.hasNext()) 
		{
			ExtendedIterator<? extends OntResource> y2 =CityClass.listInstances();
			OntResource area_resource=x1.next();
			String city = area_resource.getProperty(stop_name).getString();
			while(y2.hasNext()) 
			{
				OntResource resource=y2.next();
				if(city.contains(resource.getProperty(CityName).getString())) 
				{
					resource.addProperty(hasStopArea, area_resource);
				}
			}
		}
		ExtendedIterator<? extends OntResource> x2 = TransferClass.listInstances();
		while(x2.hasNext()) 
		{
			ExtendedIterator<? extends OntResource> y2 =StopPointClass.listInstances();
			ExtendedIterator<? extends OntResource> y3 =StopPointClass.listInstances();
			OntResource Transfer_resource=x2.next();
			String Transfer_From_stop_point = Transfer_resource.getProperty(from_stop_id).getString();
			String Transfer_To_stop_point = Transfer_resource.getProperty(to_stop_id).getString();
			while(y2.hasNext()) 
			{
				OntResource stop_point_resource1=y2.next();
				if((stop_point_resource1.getProperty(stop_id).getString()).equals(Transfer_From_stop_point)) 
				{
					while(y3.hasNext()) 
					{
						OntResource stop_point_resource2=y3.next();
						if((stop_point_resource2.getProperty(stop_id).getString()).equals(Transfer_To_stop_point)) 
						{
							stop_point_resource1.addProperty(ToStopPoint, stop_point_resource2);
						}
					}
				}
			}
		}
		FileWriter myWriter = new FileWriter("filename.txt");
	    model.write(myWriter);
	    myWriter.close();
	    System.out.println("Done");
		//model.write(System.out);
		
	}
	
	public static ArrayList <String> split (String x)
	{
		ArrayList <String> Strings = new ArrayList();
		int comma=x.indexOf(',');
		String f = x.substring(0,comma);
		Strings.add(f);
		x=x.substring(comma);
		Strings=ff(x,Strings);
		return Strings;
	}
	public static ArrayList <String> ff (String x,ArrayList <String> Strings)
	{
		if(x.charAt(0) == ',') 
		{
			x=x.substring(1);
			int comma=x.indexOf(',');
			if(comma!=-1) 
			{
				String f = x.substring(0,comma);
				Strings.add(f);
				x=x.substring(comma);
				ff(x,Strings);
			}
			else
			{
				Strings.add(x);
			}
		}
		return Strings;
	}
}
/*Individual s = Stop_TimeClass.createIndividual(baseUri+"Stop_Time_Individual "+i4);
s.addProperty(trip_id, data.get(0));
s.addProperty(arrival_time, data.get(1));
s.addProperty(departure_time, data.get(2));
s.addProperty(stop_id, data.get(3));
s.addProperty(stop_sequence, data.get(4));
s.addProperty(stop_headsign, data.get(5));
s.addProperty(pickup_type, data.get(6));
s.addProperty(drop_off_type, data.get(7));
s.addProperty(shape_dist_traveled, data.get(8));*/

/*DatatypeProperty stop_id = model.createDatatypeProperty( baseUri + "stop_id" );
stop_id.addDomain( Stop_TimeClass );
stop_id.addRange( XSD.xstring);*/