package omdb;


public class ExculatorServices implements Runnable {

	private String filmAdi;
	private String filmTuru;
	public static int sayac=0;
		
public  String getFilmAdi(){
		return filmAdi;
	}
	
	public void setFilmAdi(String filmAdi){
	this.filmAdi=filmAdi;
	}
	
public  String getfilmTuru(){
		return filmTuru;
	}
	
	public void setFilmTuru(String filmTuru){
		this.filmTuru=filmTuru;
	}
	
	public ExculatorServices(String filmAdi, String filmTuru) {
		
		this.filmAdi=filmAdi;
		this.filmTuru=filmTuru;
	}
	
	@Override
	public void run() {
		
			sayac++;
			System.out.println(sayac+".film adý : " + filmAdi +" ; "+"Filmin türü : "+ filmTuru);
				
	}
	
}