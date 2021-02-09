package geekseat.witch.saga.WitchSaga.Controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import geekseat.witch.saga.WitchSaga.dao.DataRequest;

@RestController
public class ProcessControl {
	
	Gson gson = new Gson();

	@PostMapping(value = {"#{${returnOfTheCoder.path}}"})
	public ResponseEntity<String> fightWitch(@RequestBody String requestBody){
		HttpHeaders respondHeader = new HttpHeaders();
		respondHeader.set("Content-type", "application/json");
		HttpStatus httpStatus;
		String response= null;
		
		try {
			DataRequest dataReq = new DataRequest();
			dataReq = gson.fromJson(requestBody, DataRequest.class);			
			response = processData(dataReq);
			httpStatus = HttpStatus.valueOf(200);
			
		}catch (Exception e) {
			// TODO: handle exception
			response = "The result is : -1";
			httpStatus = HttpStatus.valueOf(400);
		}
		
		
		return new ResponseEntity<>(response, respondHeader, httpStatus);
	}
	
	
	private String processData (DataRequest dataReq) {
		String result = null;
		try {
			int sumForAverage = 0;
			double averageAll = 0;
			int ctDataPerson = dataReq.getDataPerson().size();
			Boolean isValid = true;
			for(DataRequest.ReqData arrReq: dataReq.getDataPerson()) {
				int yearOfDeath = arrReq.getYearOfDeath();
				int ageOfDeath = arrReq.getAgeOfDeath();
				int selisihYear = yearOfDeath-ageOfDeath;
				int numPeopleKill=0; 
				
				if(yearOfDeath<0 ||ageOfDeath<0) {
					isValid= false;
					break;
				}
				
				if(selisihYear==1) {
					numPeopleKill = 1;
				}else if(selisihYear==2) {
					numPeopleKill = 2;
				}else if(selisihYear>2) {
					int banyakLoop = selisihYear-2; 
					int pembanding =1;
					int angkaSekarang= 2;
					int i,num;				
					while(banyakLoop>=pembanding) {
						Boolean isAddPenammbah = false;
						int resAkhir=2;
						for (i = 2; i <= angkaSekarang; i++) {
							int prima = 0;							
							for (num = 1; num <= i; num++) {
								if (i % num == 0)
				                {
				                    prima = prima + 1;
				                }
							}
							if (prima == 2)
				            {
								resAkhir = resAkhir+i;
								numPeopleKill=resAkhir;
				                isAddPenammbah= true;
				            }else {
				            	isAddPenammbah= false;
				            }
						}
						if(isAddPenammbah) {
							pembanding++;
						}
						angkaSekarang++;
					}
					
				}else {
					isValid= false;
					numPeopleKill = -1; 
					break;
				}
				sumForAverage=sumForAverage+numPeopleKill;
	
			}//close looping for
		
			if(isValid) {
				averageAll = (double)sumForAverage/(double)ctDataPerson;
				result = "The result is : "+averageAll;
			}else {
				result = "The result is : -1";
			}
		}catch (Exception e) {
			// TODO: handle exception
			result="The result is : -1";
		}
		return result;
	}
	
	
}
