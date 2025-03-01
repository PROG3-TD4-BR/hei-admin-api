package school.hei.haapi.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.Course;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.repository.CourseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Course> getCourses(PageFromOne page, BoundedPageSize pageSize){
        if (page == null){
            page = new PageFromOne(1);
        }
        if (pageSize == null){
            pageSize = new BoundedPageSize(15);
        }

        Pageable pageable = PageRequest.of(
                page.getValue() -1,
                pageSize.getValue());
        return courseRepository.findAll(pageable).getContent();
    }
}
