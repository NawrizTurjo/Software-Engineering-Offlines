package StructuralPatterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Step 1: Define our Target interface - the unified patient data provider
interface PatientDataProvider {
    PatientInfo getPatientInfo(String patientId);

    List<MedicalRecord> getMedicalHistory(String patientId);

    List<LabResult> getLabResults(String patientId, Date startDate, Date endDate);

    List<VitalSign> getVitalSigns(String patientId, Date startDate, Date endDate);
}

// Common data models
class PatientInfo {
    private String patientId;
    private String name;
    private Date dateOfBirth;
    private String gender;

    public PatientInfo(String patientId, String name, Date dateOfBirth, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient: " + name + " (ID: " + patientId + ", DoB: " + dateOfBirth + ", Gender: " + gender + ")";
    }
}

class MedicalRecord {
    private Date date;
    private String doctorName;
    private String diagnosis;
    private String treatment;

    public MedicalRecord(Date date, String doctorName, String diagnosis, String treatment) {
        this.date = date;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Medical Record [Date: " + date + ", Doctor: " + doctorName +
                ", Diagnosis: " + diagnosis + ", Treatment: " + treatment + "]";
    }
}

class LabResult {
    private Date date;
    private String testName;
    private String result;
    private String unit;
    private String referenceRange;

    public LabResult(Date date, String testName, String result, String unit, String referenceRange) {
        this.date = date;
        this.testName = testName;
        this.result = result;
        this.unit = unit;
        this.referenceRange = referenceRange;
    }

    @Override
    public String toString() {
        return "Lab Result [Date: " + date + ", Test: " + testName +
                ", Result: " + result + " " + unit + ", Reference: " + referenceRange + "]";
    }
}

class VitalSign {
    private Date timestamp;
    private String type;
    private double value;
    private String unit;

    public VitalSign(Date timestamp, String type, double value, String unit) {
        this.timestamp = timestamp;
        this.type = type;
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Vital Sign [Time: " + timestamp + ", Type: " + type +
                ", Value: " + value + " " + unit + "]";
    }
}

// Step 2: Create our Adaptee classes (the systems we need to adapt)

// Hospital EMR System - XML-based
class HospitalEMRSystem {
    public String getPatientXML(String patientId) {
        // This would actually make an XML request to the hospital system
        return "<patient id='" + patientId + "'>" +
                "<name>John Doe</name>" +
                "<dob>1980-05-15</dob>" +
                "<gender>Male</gender>" +
                "</patient>";
    }

    public String getMedicalRecordsXML(String patientId) {
        // Simplified representation of XML medical records
        return "<records>" +
                "<record><date>2023-01-15</date><doctor>Dr. Smith</doctor>" +
                "<diagnosis>Hypertension</diagnosis><treatment>Prescribed lisinopril</treatment></record>" +
                "</records>";
    }
}

// Lab Results System - JSON/REST based
class LabResultsSystem {
    public String fetchPatientData(String patientId) {
        // This would actually make a REST call to get JSON data
        return "{\"patientId\": \"" + patientId + "\", " +
                "\"name\": \"John Doe\", " +
                "\"tests\": [{\"date\": \"2023-02-10\", \"name\": \"Blood Glucose\", " +
                "\"result\": \"95\", \"unit\": \"mg/dL\", \"range\": \"70-99\"}]}";
    }
}

// Legacy Patient Database - CSV based
class LegacyPatientDatabase {
    public String getPatientCSV(String patientId) {
        // This would actually query a database and export CSV
        return "PATIENT_ID,NAME,DOB,GENDER\n" +
                patientId + ",John Doe,1980-05-15,Male";
    }

    public String getVitalsCSV(String patientId, String startDate, String endDate) {
        // Simplified CSV for vital signs
        return "TIMESTAMP,TYPE,VALUE,UNIT\n" +
                "2023-03-01 08:00,Blood Pressure,120/80,mmHg\n" +
                "2023-03-01 08:01,Heart Rate,72,bpm";
    }
}

// Wearable Device System - Binary format (simulated)
class WearableDeviceSystem {
    public byte[] getVitalsData(String patientId, long startTimestamp, long endTimestamp) {
        // This would actually connect to a device API and get binary data
        // We're simulating the binary data with a simple string representation
        String simulatedData = "HEARTRATE:75;STEPS:5420;SLEEP:7.5";
        return simulatedData.getBytes();
    }
}

// Step 3: Create Adapters for each system

// Hospital EMR Adapter
class HospitalEMRAdapter implements PatientDataProvider {
    private HospitalEMRSystem emrSystem;

    public HospitalEMRAdapter(HospitalEMRSystem emrSystem) {
        this.emrSystem = emrSystem;
    }

    @Override
    public PatientInfo getPatientInfo(String patientId) {
        String xml = emrSystem.getPatientXML(patientId);
        // In real implementation, we would parse the XML properly
        // This is a simplified example
        String name = extractFromXml(xml, "name");
        String dob = extractFromXml(xml, "dob");
        String gender = extractFromXml(xml, "gender");

        return new PatientInfo(patientId, name, parseDate(dob), gender);
    }

    @Override
    public List<MedicalRecord> getMedicalHistory(String patientId) {
        String xml = emrSystem.getMedicalRecordsXML(patientId);
        List<MedicalRecord> records = new ArrayList<>();

        // Simplified XML parsing - in a real system, use proper XML parser
        // Extract date, doctor, diagnosis, and treatment from XML and create
        // MedicalRecord objects
        records.add(new MedicalRecord(parseDate("2023-01-15"), "Dr. Smith",
                "Hypertension", "Prescribed lisinopril"));

        return records;
    }

    @Override
    public List<LabResult> getLabResults(String patientId, Date startDate, Date endDate) {
        // Hospital EMR doesn't provide lab results, so return empty list
        return new ArrayList<>();
    }

    @Override
    public List<VitalSign> getVitalSigns(String patientId, Date startDate, Date endDate) {
        // Hospital EMR doesn't provide vital signs, so return empty list
        return new ArrayList<>();
    }

    private String extractFromXml(String xml, String tag) {
        // Very simplified XML parsing - in a real system, use a proper XML parser
        int startIndex = xml.indexOf("<" + tag + ">") + tag.length() + 2;
        int endIndex = xml.indexOf("</" + tag + ">");
        return xml.substring(startIndex, endIndex);
    }

    private Date parseDate(String dateString) {
        try {
            // Simple date parsing - in a real system, use proper date parsing
            return new Date();
        } catch (Exception e) {
            return new Date();
        }
    }
}

// Lab Results System Adapter
class LabResultsAdapter implements PatientDataProvider {
    private LabResultsSystem labSystem;

    public LabResultsAdapter(LabResultsSystem labSystem) {
        this.labSystem = labSystem;
    }

    @Override
    public PatientInfo getPatientInfo(String patientId) {
        // Lab system has limited patient info, so we extract what we can
        String json = labSystem.fetchPatientData(patientId);
        // In real implementation, we would parse the JSON properly
        // This is simplified
        return new PatientInfo(patientId, "John Doe", new Date(), "Unknown");
    }

    @Override
    public List<MedicalRecord> getMedicalHistory(String patientId) {
        // Lab system doesn't provide medical history
        return new ArrayList<>();
    }

    @Override
    public List<LabResult> getLabResults(String patientId, Date startDate, Date endDate) {
        String json = labSystem.fetchPatientData(patientId);
        List<LabResult> results = new ArrayList<>();

        // Simplified JSON parsing - would use a proper JSON parser in real system
        results.add(new LabResult(new Date(), "Blood Glucose", "95", "mg/dL", "70-99"));

        return results;
    }

    @Override
    public List<VitalSign> getVitalSigns(String patientId, Date startDate, Date endDate) {
        // Lab system doesn't provide vital signs
        return new ArrayList<>();
    }
}

// Legacy Patient Database Adapter
class LegacyDatabaseAdapter implements PatientDataProvider {
    private LegacyPatientDatabase legacyDb;

    public LegacyDatabaseAdapter(LegacyPatientDatabase legacyDb) {
        this.legacyDb = legacyDb;
    }

    @Override
    public PatientInfo getPatientInfo(String patientId) {
        String csv = legacyDb.getPatientCSV(patientId);
        // Parse the CSV to extract patient info
        // This is simplified
        String[] lines = csv.split("\n");
        if (lines.length > 1) {
            String[] fields = lines[1].split(",");
            return new PatientInfo(fields[0], fields[1], parseDate(fields[2]), fields[3]);
        }
        return null;
    }

    @Override
    public List<MedicalRecord> getMedicalHistory(String patientId) {
        // Legacy DB doesn't store medical history
        return new ArrayList<>();
    }

    @Override
    public List<LabResult> getLabResults(String patientId, Date startDate, Date endDate) {
        // Legacy DB doesn't store lab results
        return new ArrayList<>();
    }

    @Override
    public List<VitalSign> getVitalSigns(String patientId, Date startDate, Date endDate) {
        String dateFormat = "yyyy-MM-dd"; // Simplified
        String csv = legacyDb.getVitalsCSV(patientId, formatDate(startDate, dateFormat),
                formatDate(endDate, dateFormat));

        List<VitalSign> vitalSigns = new ArrayList<>();
        // Parse CSV for vital signs - simplified implementation
        String[] lines = csv.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] fields = lines[i].split(",");
            if (fields.length >= 4) {
                if (fields[1].equals("Blood Pressure")) {
                    vitalSigns.add(new VitalSign(parseDate(fields[0]), fields[1],
                            parseBloodPressure(fields[2]), fields[3]));
                } else {
                    vitalSigns.add(new VitalSign(parseDate(fields[0]), fields[1],
                            Double.parseDouble(fields[2]), fields[3]));
                }
            }
        }

        return vitalSigns;
    }

    private String formatDate(Date date, String format) {
        // In real code, use SimpleDateFormat
        return "2023-03-01";
    }

    private Date parseDate(String dateStr) {
        // In real code, use SimpleDateFormat
        return new Date();
    }

    private double parseBloodPressure(String bp) {
        // Extract systolic pressure as a representative number
        return 120.0;
    }
}

// Wearable Device Adapter
class WearableDeviceAdapter implements PatientDataProvider {
    private WearableDeviceSystem wearableSystem;

    public WearableDeviceAdapter(WearableDeviceSystem wearableSystem) {
        this.wearableSystem = wearableSystem;
    }

    @Override
    public PatientInfo getPatientInfo(String patientId) {
        // Wearables don't store complete patient info
        return null;
    }

    @Override
    public List<MedicalRecord> getMedicalHistory(String patientId) {
        // Wearables don't store medical history
        return new ArrayList<>();
    }

    @Override
    public List<LabResult> getLabResults(String patientId, Date startDate, Date endDate) {
        // Wearables don't store lab results
        return new ArrayList<>();
    }

    @Override
    public List<VitalSign> getVitalSigns(String patientId, Date startDate, Date endDate) {
        byte[] binaryData = wearableSystem.getVitalsData(patientId, startDate.getTime(), endDate.getTime());

        // Convert binary data to string for this example
        String data = new String(binaryData);
        List<VitalSign> vitalSigns = new ArrayList<>();

        // Parse the simulated data - in real code would parse actual binary format
        String[] metrics = data.split(";");
        for (String metric : metrics) {
            String[] parts = metric.split(":");
            if (parts.length == 2) {
                String type = parts[0];
                double value = Double.parseDouble(parts[1]);
                String unit = getUnitForMetric(type);
                vitalSigns.add(new VitalSign(new Date(), type, value, unit));
            }
        }

        return vitalSigns;
    }

    private String getUnitForMetric(String metric) {
        switch (metric) {
            case "HEARTRATE":
                return "bpm";
            case "STEPS":
                return "count";
            case "SLEEP":
                return "hours";
            default:
                return "";
        }
    }
}

// Step 4: Create a PatientDataFacade that uses the adapters
class PatientDataFacade implements PatientDataProvider {
    private List<PatientDataProvider> providers;

    public PatientDataFacade() {
        providers = new ArrayList<>();
    }

    public void addProvider(PatientDataProvider provider) {
        providers.add(provider);
    }

    @Override
    public PatientInfo getPatientInfo(String patientId) {
        for (PatientDataProvider provider : providers) {
            PatientInfo info = provider.getPatientInfo(patientId);
            if (info != null) {
                return info;
            }
        }
        return null;
    }

    @Override
    public List<MedicalRecord> getMedicalHistory(String patientId) {
        List<MedicalRecord> allRecords = new ArrayList<>();
        for (PatientDataProvider provider : providers) {
            List<MedicalRecord> records = provider.getMedicalHistory(patientId);
            if (records != null && !records.isEmpty()) {
                allRecords.addAll(records);
            }
        }
        return allRecords;
    }

    @Override
    public List<LabResult> getLabResults(String patientId, Date startDate, Date endDate) {
        List<LabResult> allResults = new ArrayList<>();
        for (PatientDataProvider provider : providers) {
            List<LabResult> results = provider.getLabResults(patientId, startDate, endDate);
            if (results != null && !results.isEmpty()) {
                allResults.addAll(results);
            }
        }
        return allResults;
    }

    @Override
    public List<VitalSign> getVitalSigns(String patientId, Date startDate, Date endDate) {
        List<VitalSign> allVitalSigns = new ArrayList<>();
        for (PatientDataProvider provider : providers) {
            List<VitalSign> vitalSigns = provider.getVitalSigns(patientId, startDate, endDate);
            if (vitalSigns != null && !vitalSigns.isEmpty()) {
                allVitalSigns.addAll(vitalSigns);
            }
        }
        return allVitalSigns;
    }
}

// Step 5: Demonstrate the Healthcare Adapter Pattern
public class HealthcareAdapterDemo {
    public static void main(String[] args) {
        // Create instances of all our systems (adaptees)
        HospitalEMRSystem emrSystem = new HospitalEMRSystem();
        LabResultsSystem labSystem = new LabResultsSystem();
        LegacyPatientDatabase legacyDb = new LegacyPatientDatabase();
        WearableDeviceSystem wearableSystem = new WearableDeviceSystem();

        // Create adapters for each system
        PatientDataProvider emrAdapter = new HospitalEMRAdapter(emrSystem);
        PatientDataProvider labAdapter = new LabResultsAdapter(labSystem);
        PatientDataProvider legacyAdapter = new LegacyDatabaseAdapter(legacyDb);
        PatientDataProvider wearableAdapter = new WearableDeviceAdapter(wearableSystem);

        // Create the facade and add all providers
        PatientDataFacade facade = new PatientDataFacade();
        facade.addProvider(emrAdapter);
        facade.addProvider(labAdapter);
        facade.addProvider(legacyAdapter);
        facade.addProvider(wearableAdapter);

        // Now use the unified interface to get data
        String patientId = "P12345";
        Date startDate = new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000); // 7 days ago
        Date endDate = new Date();

        // Get patient info (could come from any provider)
        PatientInfo patientInfo = facade.getPatientInfo(patientId);
        System.out.println("Patient Information:");
        System.out.println(patientInfo);
        System.out.println();

        // Get medical history (likely from EMR)
        List<MedicalRecord> medicalHistory = facade.getMedicalHistory(patientId);
        System.out.println("Medical History:");
        for (MedicalRecord record : medicalHistory) {
            System.out.println(record);
        }
        System.out.println();

        // Get lab results (likely from Lab System)
        List<LabResult> labResults = facade.getLabResults(patientId, startDate, endDate);
        System.out.println("Lab Results:");
        for (LabResult result : labResults) {
            System.out.println(result);
        }
        System.out.println();

        // Get vital signs (could come from multiple sources)
        List<VitalSign> vitalSigns = facade.getVitalSigns(patientId, startDate, endDate);
        System.out.println("Vital Signs:");
        for (VitalSign vitalSign : vitalSigns) {
            System.out.println(vitalSign);
        }
    }
}

/*
 * Complex Adapter Pattern Problem: Multi-format Data Integration System
 * Here's a complex problem that demonstrates the power of the Adapter Pattern:
 * 
 * Problem Statement: Healthcare Data Integration System
 * A healthcare organization needs to build a centralized patient records system
 * that can integrate data from multiple sources with different formats and
 * APIs:
 * 
 * Hospital EMR System: Uses XML-based data exchange
 * Lab Results System: Provides data in JSON format through REST APIs
 * Legacy Patient Database: Offers data through CSV file exports
 * Wearable Device Data: Streams data in a proprietary binary format
 * Your task is to design a system that unifies access to all these disparate
 * data sources through a single consistent interface, allowing the application
 * to retrieve patient information without knowing which underlying system the
 * data comes from.
 * 
 * Requirements:
 * Create a unified PatientDataProvider interface that exposes methods like:
 * 
 * getPatientInfo(String patientId)
 * getMedicalHistory(String patientId)
 * getLabResults(String patientId, Date startDate, Date endDate)
 * getVitalSigns(String patientId, Date startDate, Date endDate)
 * Implement adapter classes for each data source that convert the
 * source-specific formats and methods to the unified interface.
 * 
 * Include proper error handling for when a specific data source is unavailable
 * or returns incomplete data.
 * 
 * Implement a façade that intelligently combines data from multiple sources
 * when needed.
 * 
 * Design the system to be easily extensible for future data sources.
 * 
 * This problem demonstrates the real power of the Adapter Pattern, as it allows
 * you to integrate multiple incompatible interfaces into a unified system while
 * maintaining clean separation of concerns and single responsibility for each
 * adapter.
 */