package LibraryManagement.Model;

public class Reader {
    private int readerId;
    private String readerName;
    private String identificationId;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String occupation;
    private String email;

    public Reader() {
    }

    public Reader(int readerId, String readerName, String identificationId, String dateOfBirth,
                  String gender, String address, String occupation, String email) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.identificationId = identificationId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.occupation = occupation;
        this.email = email;
    }
    public Reader(String readerName, String identificationId, String dateOfBirth, String address, String occupation, String email) {
        this.readerName = readerName;
        this.identificationId = identificationId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.occupation = occupation;
        this.email = email;
    }

    public Reader(int readerId, String readerName, String identificationId, String dateOfBirth, String address, String occupation, String email) {
        this.readerId = readerId;
        this.readerName = readerName;
        this.identificationId = identificationId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.occupation = occupation;
        this.email = email;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(String identificationId) {
        this.identificationId = identificationId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
