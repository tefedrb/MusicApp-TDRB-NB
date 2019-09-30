package MusicApp.service;


import MusicApp.models.Course;

public interface CourseService {

    public Course createCourse(Course course);

    public Iterable<Course> listCourses();
}