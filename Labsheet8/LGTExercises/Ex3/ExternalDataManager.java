package Ex3;

public interface ExternalDataManager {
    
    public void setTaxi(boolean isTaxi);
	public boolean isTaxi();

	public void setMOTCertificate(boolean mot);
	public boolean hasMOTCertificate();

    public float getEmissionsData();
}