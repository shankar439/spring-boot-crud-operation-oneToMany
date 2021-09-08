package com.crudOperation.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudOperation.example.entity.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	List<Subject> findByStudent(int id);

}

/*public BaseResponse getStudentDetailsByID(int id) {
BaseResponse baseResponse=new BaseResponse();
   List<ListDto> listDTOS = new LinkedList<>();
   List<Subject> subjectList = subjectRepository.findAll();

       List<Subject> book2=studentRepository.findByStudentId(id);
       book2.stream().forEachOrdered(book3 -> {
           List<SubjectDto> bookDTO1=new LinkedList<>();
           SubjectDto bookDTO =new SubjectDto();
           bookDTO.setSubjectName(book3.getSubjectName());
           bookDTO1.add(bookDTO);
           ListDto listDTO=new ListDto();
           listDTO.setId(book3.getStudent().getId());
           listDTO.setCity(book3.getStudent().getCity());
           listDTO.setName(book3.getStudent().getName());
           listDTOS.add(listDTO);
       });
       baseResponse.setStatusCode("200");
       baseResponse.setStatusMsg("success");
       //baseResponse.setData(listDTOS);
       return baseResponse;
   }*/