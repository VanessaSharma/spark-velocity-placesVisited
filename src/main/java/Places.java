public class Places {
  private String mCountry;
  private String mCity;
  private Integer mYear;
  private String mPurpose;

  public Places(String country, String city, Integer year, String purpose) {
    mCountry = country;
    mCity = city;
    mYear = year;
    mPurpose = purpose;
  }

  public String getCountry() {
    return mCountry;
  }
  public String getCity() {
    return mCity;
  }
  public Integer getYear() {
    return mYear;
  }
  public String getPurpose() {
    return mPurpose;
  }

  public String suggestOtherPlaces() {
    String suggestions = "";
    if (mPurpose.contains("work") == true) {
      suggestions = "Bermuda, Bahamas";
    } else if (mPurpose.contains("business")) {
      suggestions = "Key Largo, Montigo";
    } else if (mPurpose.contains("vacation")) {
      suggestions = "Kokomo";
    }
    return suggestions;
  }

}
