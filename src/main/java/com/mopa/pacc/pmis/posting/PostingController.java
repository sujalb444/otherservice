package com.mopa.pacc.pmis.posting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mopa.pacc.pmis.general.GeneralInfo;
import com.mopa.pacc.pmis.general.GeneralInfoService;

// import com.mopa.pacc.pmis.posting.Posting;
// import com.mopa.pacc.pmis.posting.PostingRepository;
/**
 * 
 * Controller class to access service layer data
 */
@RestController
@RequestMapping("/api")
public class PostingController {
    @Autowired
    PostingService postingService;

    @Autowired
    GeneralInfoService generalInfoService;

    @GetMapping("/postings")
    public ResponseEntity<List<Posting>> getAllPostings(@RequestParam(required = false) String designation) {
        try {
            List<Posting> postings = new ArrayList<Posting>();
            if (designation == null) {
                postingService.getAllPostings().forEach(postings::add);
            } else {
                postingService.findByDesignation(designation).forEach(postings::add);
            }
            if (postings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(postings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/postings")
    public ResponseEntity<Posting> createPosting(@RequestBody PostingDto param) {
        try {
            Posting posting = new Posting();

            posting.setDesignation(param.getDesignation());
            posting.setOrganization(param.getOrganization());
            posting.setLocation(param.getLocation());
            posting.setRank(param.getRank());

            String govId = param.getGovId();

            // Check if Gov ID is exist
            GeneralInfo generalInfo = generalInfoService.findByGovId(govId)
                    .orElseThrow(() -> new Exception("Gov ID not found"));

            // We pulled genealInfo object from DB by govId (generalId, govId, firstName,
            // lastName)

            posting.setGeneralInfo(generalInfo);

            Posting _posting = postingService.save(posting);

            return new ResponseEntity<>(_posting, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/postings/{id}")
    public ResponseEntity<Posting> getPostingById(@PathVariable("id") Long id) {
        Optional<Posting> postingData = postingService.findById(id);

        if (postingData.isPresent()) {
            return new ResponseEntity<>(postingData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/postings/{id}")
    public ResponseEntity<Posting> updatePosting(@PathVariable("id") Long id, @RequestBody PostingDto param) {
        try {
            Optional<Posting> postingData = postingService.findById(id);
            if (postingData.isPresent()) {
                Posting _posting = postingData.get();
                _posting.setDesignation(param.getDesignation());
                _posting.setOrganization(param.getOrganization());
                _posting.setLocation(param.getLocation());
                _posting.setRank(param.getRank());
                // get gov ID
                // Check if Gov ID is exist
                GeneralInfo generalInfo = generalInfoService.findByGovId(param.getGovId())
                        .orElseThrow(() -> new Exception("Gov ID not found"));

                // We pulled genealInfo object from DB by govId (generalId, govId, firstName,
                // lastName)

                _posting.setGeneralInfo(generalInfo);

                return new ResponseEntity<>(postingService.save(_posting), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/postings/{id}")
    public ResponseEntity<HttpStatus> deletePosting(@PathVariable("id") long id) {
        try {
            postingService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Find list of posting data by designation
     * 
     * @param param
     * @return
     */
    @PostMapping("/postings/designation")
    public ResponseEntity<List<Posting>> getPostingByDesignation(@RequestBody Posting param) {
        try {
            List<Posting> postings = new ArrayList<Posting>();
            postingService.findByDesignation(param.getDesignation()).forEach(postings::add);
            if (postings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(postings, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
