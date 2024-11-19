import org.springframework.data.repository.CrudRepository;

import com.proyect_name.models.Course;

public interface ICourseRepository extends CrudRepository<Course, Integer> {
	Course findBy(Integer id);
}