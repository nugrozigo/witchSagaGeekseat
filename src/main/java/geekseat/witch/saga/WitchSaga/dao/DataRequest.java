package geekseat.witch.saga.WitchSaga.dao;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataRequest {
	
	List<DataRequest.ReqData> dataPerson;
	
	@Getter
	@Setter
	public static class ReqData{
		Integer ageOfDeath;
		Integer yearOfDeath;
	}
	

}
