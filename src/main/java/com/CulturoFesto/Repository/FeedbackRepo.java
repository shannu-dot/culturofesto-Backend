package com.CulturoFesto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CulturoFesto.Model.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback,String> {

}

