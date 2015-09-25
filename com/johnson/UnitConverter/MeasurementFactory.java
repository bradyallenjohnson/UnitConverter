package com.johnson.UnitConverter;

import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

import com.johnson.UnitConverter.Measurement;
import com.johnson.UnitConverter.MeasurementUnit;
import com.johnson.UnitConverter.units.MeasurementUnitCurrency;
import com.johnson.UnitConverter.units.MeasurementUnitFahrenheit;
import com.johnson.UnitConverter.units.MeasurementUnitKelvin;
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
	public final static String MEASURE_POWER		= "Power";
	public final static String MEASURE_PRESSURE		= "Pressure";
	public final static String MEASURE_SPEED		= "Speed";
	public final static String MEASURE_ANGLE        = "Angle Measurements";
	public final static String MEASURE_CURRENCY     = "Currency";

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

	public final static String UNIT_VOLUME_LITER     = "liter";
	public final static String UNIT_VOLUME_MILILITER = "mililiter";
	public final static String UNIT_VOLUME_GALLON    = "gallon";
	public final static String UNIT_VOLUME_CUP       = "cup";
	public final static String UNIT_VOLUME_PINT      = "pint";
	public final static String UNIT_VOLUME_QUART     = "quart";
	public final static String UNIT_VOLUME_OUNCE     = "ounce";

	public final static String UNIT_TEMP_CELSIUS    = "celsius";
	public final static String UNIT_TEMP_FAHRENHEIT = "fahrenheit";
	public final static String UNIT_TEMP_KELVIN     = "kelvin";

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
	
	public final static String UNIT_POWER_WATT		          = "watt";
	public final static String UNIT_POWER_HORSEPOWER          = "horsepower";
	public final static String UNIT_POWER_CALORIES_PER_SECOND = "calories per second";
	public final static String UNIT_POWER_BTU_PER_SECOND      = "BTU per second";
	public final static String UNIT_POWER_MEGAWATT		      = "megawatt";
	public final static String UNIT_POWER_KILOWATT		      = "kilowatt";

	public final static String UNIT_PRESSURE_PASCAL     = "pascal";
	public final static String UNIT_PRESSURE_ATMOSPHERE = "atmosphere";
	public final static String UNIT_PRESSURE_BAR 	    = "bar";
	public final static String UNIT_PRESSURE_PSI 	    = "psi";
	public final static String UNIT_PRESSURE_TORR 	    = "torr";
	
	public final static String UNIT_SPEED_KM_PER_HOUR       = "kilometers per hour";
	public final static String UNIT_SPEED_MILES_PER_HOUR    = "miles per hour";
	public final static String UNIT_SPEED_METERS_PER_SECOND = "meters per second";
	public final static String UNIT_SPEED_KNOTS             = "knots";
	
	public final static String UNIT_ANGLE_DEGREES   = "degrees";
	public final static String UNIT_ANGLE_RADIANS   = "radians";
	public final static String UNIT_ANGLE_GRADIANS  = "gradians";
	
	public final static String UNIT_CURRENCY_USD = "U.S. Dollars";
	public final static String UNIT_CURRENCY_EUR = "Euros";
	public final static String UNIT_CURRENCY_GBP = "British Pounds";
	public final static String UNIT_CURRENCY_INR = "Indian Rupee";
	public final static String UNIT_CURRENCY_AUD = "Australian Dollars";
	public final static String UNIT_CURRENCY_CAD = "Canadian Dollars";
	public final static String UNIT_CURRENCY_SGD = "Singapore Dollars";
	public final static String UNIT_CURRENCY_JPY = "Japanese Yen";
	public final static String UNIT_CURRENCY_CNY = "Chinese Yuan";
	public final static String UNIT_CURRENCY_RUB = "Russian Ruble";
	
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
		temperatureMeasurements.addUnit(new MeasurementUnitKelvin(UNIT_TEMP_KELVIN));

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
		// Power
		//   The reference will be watt
		//
		Measurement powerMeasurements = new Measurement(MEASURE_POWER);
		powerMeasurements.setDecimalPlaces(3);
		powerMeasurements.addUnit(new MeasurementUnit(UNIT_POWER_WATT));
		powerMeasurements.addUnit(new MeasurementUnit(UNIT_POWER_HORSEPOWER,          1.0/745.699872));
		powerMeasurements.addUnit(new MeasurementUnit(UNIT_POWER_CALORIES_PER_SECOND, 0.239005736));
		powerMeasurements.addUnit(new MeasurementUnit(UNIT_POWER_BTU_PER_SECOND,      0.00094781712));
		powerMeasurements.addUnit(new MeasurementUnit(UNIT_POWER_KILOWATT,            1.0/1000));
		powerMeasurements.addUnit(new MeasurementUnit(UNIT_POWER_MEGAWATT,            1.0/1000000));
		
		
		//
		// Pressure
		//    The reference will be pascal
		//
		Measurement pressureMeasurements = new Measurement(MEASURE_PRESSURE);
		pressureMeasurements.addUnit(new MeasurementUnit(UNIT_PRESSURE_PASCAL));
		pressureMeasurements.addUnit(new MeasurementUnit(UNIT_PRESSURE_ATMOSPHERE, 1.0/101325));
		pressureMeasurements.addUnit(new MeasurementUnit(UNIT_PRESSURE_BAR,        1.0/100000));
		pressureMeasurements.addUnit(new MeasurementUnit(UNIT_PRESSURE_PSI,        1.0/6894.75729));
		pressureMeasurements.addUnit(new MeasurementUnit(UNIT_PRESSURE_TORR,       1.0/133.322368));
		
		//
		// Speed
		//   The reference will be kilometers per hour
		//
		Measurement speedMeasurements = new Measurement(MEASURE_SPEED);
		speedMeasurements.addUnit(new MeasurementUnit(UNIT_SPEED_KM_PER_HOUR));
		speedMeasurements.addUnit(new MeasurementUnit(UNIT_SPEED_METERS_PER_SECOND, 1.0/3.6));
		speedMeasurements.addUnit(new MeasurementUnit(UNIT_SPEED_MILES_PER_HOUR,    1.0/1.609344));
		speedMeasurements.addUnit(new MeasurementUnit(UNIT_SPEED_KNOTS,             1.0*0.539956803));
		
		//
		//Angular Measure
		//   The reference will be Degrees
		//
		Measurement angleMeasurements = new Measurement(MEASURE_ANGLE);
		angleMeasurements.addUnit(new MeasurementUnit(UNIT_ANGLE_DEGREES));
		angleMeasurements.addUnit(new MeasurementUnit(UNIT_ANGLE_RADIANS, 1.0/57.2957795));
		angleMeasurements.addUnit(new MeasurementUnit(UNIT_ANGLE_GRADIANS, 1.0/0.9));
		
		//
		//Currency
		//	The reference will be U.S. Dollars (USD)
		//
		Measurement currencyMeasurements = new Measurement(MEASURE_CURRENCY);
		MeasurementUnitCurrency rate = new MeasurementUnitCurrency();
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_USD));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_EUR, rate.getRate("EUR")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_GBP, rate.getRate("GBP")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_INR, rate.getRate("INR")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_AUD, rate.getRate("AUD")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_CAD, rate.getRate("CAD")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_SGD, rate.getRate("SGD")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_JPY, rate.getRate("JPY")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_CNY, rate.getRate("CNY")));
		currencyMeasurements.addUnit(new MeasurementUnit(UNIT_CURRENCY_RUB, rate.getRate("RUB")));
		
		//
		// Populate the map
		//
		this.measurements.put(MEASURE_LENGTH,       lengthMeasurements);
		this.measurements.put(MEASURE_WEIGHT,       weightMeasurements);
		this.measurements.put(MEASURE_TEMPERATURE,  temperatureMeasurements);
		this.measurements.put(MEASURE_VOLUME,       volumeMeasurements);
		this.measurements.put(MEASURE_MILEAGE,      mileageMeasurements);
		this.measurements.put(MEASURE_AREA,         areaMeasurements);
		this.measurements.put(MEASURE_POWER, 		powerMeasurements);
		this.measurements.put(MEASURE_PRESSURE, 	pressureMeasurements);
		this.measurements.put(MEASURE_SPEED, 	    speedMeasurements);
		this.measurements.put(MEASURE_ANGLE,        angleMeasurements);
		this.measurements.put(MEASURE_CURRENCY,     currencyMeasurements);
	}
}
