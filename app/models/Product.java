package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


@Entity
public class Product extends Model
{
	@Id
	public String id;
	
	public Long barcode;
	public byte[] pic1;
	public byte[] pic2;
	public byte[] pic3;
	
}
