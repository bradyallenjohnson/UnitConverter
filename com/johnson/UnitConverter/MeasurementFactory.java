package com.johnson.UnitConverter;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

import com.johnson.UnitConverter.units.MeasurementUnitFahrenheit;
import com.johnson.UnitConverter.units.MeasurementUnitMileageKPL;
import com.johnson.UnitConverter.units.MeasurementUnitMileageMPG;

public class MeasurementFactory
{
	public final static String MEASURE_LENGTH       = "Length";
	public final static String MEASURE_WEIGHT       = "Weight";
	public final static String MEASURE_TEMPERATURE  = "Temperature";
	public final static String MEASURE_VOLUME       = "Volume";
	public final static String MEASURE_MILEAGE      = "Gas Mileage";
	public final static String MEASURE_AREA         = "Area";

	public final static String UNIT_LENGTH_CM       = "centimeter";
	public final static String UNIT_LENGTH_METER    = "meter";
	public final static String UNIT_LENGTH_KM       = "kilometer";
	public final static String UNIT_LENGTH_INCH     = "inch";
	public final static String UNIT_LENGTH_FOOT     = "foot";
	public final static String UNIT_LENGTH_MILE     = "mile";

	public final static String UNIT_WEIGHT_GRAM     = "gram";
	public final static String UNIT_WEIGHT_KG       = "kilogram";
	public final static String UNIT_WEIGHT_POUND    = "pound";
	public final static String UNIT_WEIGHT_OUNCE    = "ounce";

	public final static String UNIT_VOLUME_LITER    = "liter";
	public final static String UNIT_VOLUME_MILILITER = "mililiter";
	public final static String UNIT_VOLUME_GALLON   = "gallon";
	public final static String UNIT_VOLUME_CUP      = "cup";
	public final static String UNIT_VOLUME_PINT     = "pint";
	public final static String UNIT_VOLUME_QUART    = "quart";
	public final static String UNIT_VOLUME_OUNCE    = "ounce";

	public final static String UNIT_TEMP_CELSIUS    = "celsius";
	public final static String UNIT_TEMP_FAHRENHEIT = "fahrenheit";

	public final static String UNIT_MILEAGE_LPK     = "liters per 100 km";
	public final static String UNIT_MILEAGE_KPL     = "kilometers per liter";
	public final static String UNIT_MILEAGE_MPG     = "miles per gallon";
	
	public final static String UNIT_AREA_SQ_METER   = "square meter";
	public final static String UNIT_AREA_SQ_KM      = "square km";
	public final static String UNIT_AREA_SQ_INCH    = "square inch";
	public final static String UNIT_AREA_SQ_FOOT    = "square foot";
	public final static String UNIT_AREA_SQ_YARD    = "square yard";
	public final static String UNIT_AREA_SQ_MILE    = "square mile";
	public final static String UNIT_AREA_ACRE       = "acre";
	public final static String UNIT_AREA_HECTARE    = "hectare";

	private Map<String, Measurement> measurements;
	private static MeasurementFactory instance = null;

	private MeasurementFactory()
	{
		this.measurements = new TreeMap<String, Measurement>();
	}

	public final static MeasurementFactory instance()
	{
		if(instance == null)
		{
			instance = new MeasurementFactory();
		}

		return instance;
	}

	public Set<String> getEntries()
	{
		return this.measurements.keySet();
	}

	public Measurement getMeasurement(final String measurementType)
	{
		return this.measurements.get(measurementType);
	}

	//
	// Later on, this will use Spring to load everything
	//
	public void load()
	{
		//
		// Lengths
		//   The reference will be centimeters: 1 inch = 2.54 cm
		//
		Measurement lengthMeasurements = new Measurement(MEASURE_LENGTH);
		lengthMeasurements.addUnit(new MeasurementUnit(UNIT_LENGTH_CM));
		lengthMeasurements.addUnit(new MeasurementUnit(UNIT_LENGTH_METER,  0.01));
		lengthMeasurements.addUnit(new MeasurementUnit(UNIT_LENGTH_KM,     0.00001));
		lengthMeasurements.addUnit(new MeasurementUnit(UNIT_LENGTH_INCH,   1.0/2.54));
		lengthMeasurements.addUnit(new MeasurementUnit(UNIT_LENGTH_FOOT,   1.0/(12.0*2.54)));
		lengthMeasurements.addUnit(new MeasurementUnit(UNIT_LENGTH_MILE,   1.0/(2.54*12*5280.0)));

		//
		// Weights
		//   The reference will be grams: 1 kg = 2.2 pounds
		//
		Measurement weightMeasurements = new Measurement(MEASURE_WEIGHT);
		weightMeasurements.addUnit(new MeasurementUnit(UNIT_WEIGHT_GRAM));
		weightMeasurements.addUnit(new MeasurementUnit(UNIT_WEIGHT_KG,    0.001));
		weightMeasurements.addUnit(new MeasurementUnit(UNIT_WEIGHT_POUND, 2.2/1000.0));
		weightMeasurements.addUnit(new MeasurementUnit(UNIT_WEIGHT_OUNCE, (2.2*16.0)/1000.0));

		//
		// Temperature
		//   The reference will be celsius: F = (C * 1.8) + 32 
		//
		Measurement temperatureMeasurements = new Measurement(MEASURE_TEMPERATURE);
		temperatureMeasurements.setDecimalPlaces(1);
		temperatureMeasurements.addUnit(new MeasurementUnit(UNIT_TEMP_CELSIUS));
		temperatureMeasurements.addUnit(new MeasurementUnitFahrenheit(UNIT_TEMP_FAHRENHEIT));

		//
		// Volume
		//   The reference will be liters: 1 gallon = 3.7854 liters
		//
		Measurement volumeMeasurements = new Measurement(MEASURE_VOLUME);
		volumeMeasurements.addUnit(new MeasurementUnit(UNIT_VOLUME_LITER));
		volumeMeasurements.addUnit(new MeasurementUnit(UNIT_VOLUME_MILILITER, 1000.0));
		volumeMeasurements.addUnit(new MeasurementUnit(UNIT_VOLUME_GALLON,    1.0/3.7854));
		volumeMeasurements.addUnit(new MeasurementUnit(UNIT_VOLUME_QUART,     4.0/3.7854)); // 1 gallon = 4 quarts
		volumeMeasurements.addUnit(new MeasurementUnit(UNIT_VOLUME_PINT,      8.0/3.7854));
		volumeMeasurements.addUnit(new MeasurementUnit(UNIT_VOLUME_CUP,       16.0/3.7854));
		volumeMeasurements.addUnit(new MeasurementUnit(UNIT_VOLUME_OUNCE,     128.0/3.7854));

		//
		// Gas Mileage
		//   The reference will be liters per 100 Km
		//
		Measurement mileageMeasurements = new Measurement(MEASURE_MILEAGE);
		mileageMeasurements.addUnit(new MeasurementUnit(UNIT_MILEAGE_LPK));
		mileageMeasurements.addUnit(new MeasurementUnitMileageKPL(UNIT_MILEAGE_KPL));
		mileageMeasurements.addUnit(new MeasurementUnitMileageMPG(UNIT_MILEAGE_MPG));

		//
		// Area
		//   The reference will be square meters
		//
		Measurement areaMeasurements = new Measurement(MEASURE_AREA);
		//areaMeasurements.setDecimalPlaces(6);
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_SQ_METER));
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_HECTARE, Math.pow(0.01, 2)));
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_SQ_KM,   Math.pow(0.001, 2)));
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_SQ_INCH, Math.pow((100.0/(2.54)), 2)));
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_SQ_FOOT, Math.pow((100.0/(12.0*2.54)), 2)));
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_SQ_YARD, Math.pow((100.0/(12.0*3.0*2.54)), 2)));
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_SQ_MILE, Math.pow((100.0/(12.0*5280.0*2.54)), 2)));
		areaMeasurements.addUnit(new MeasurementUnit(UNIT_AREA_ACRE,    Math.pow((100.0/(12.0*5280.0*2.54)), 2)*640.0));

		//
		// Future measurements:
		//		Area, Power, Pressure, Currency
		//

		//
		// Pupulate the map
		//
		this.measurements.put(MEASURE_LENGTH,       lengthMeasurements);
		this.measurements.put(MEASURE_WEIGHT,       weightMeasurements);
		this.measurements.put(MEASURE_TEMPERATURE,  temperatureMeasurements);
		this.measurements.put(MEASURE_VOLUME,       volumeMeasurements);
		this.measurements.put(MEASURE_MILEAGE,      mileageMeasurements);
		this.measurements.put(MEASURE_AREA,         areaMeasurements);
	}
}
