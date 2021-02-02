package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Individual;
import com.projectagile.webprojectagile.entity.Profile;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.impl.IndividualServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.IndividualReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Le controleur recoit les requêtes du front-end
 */

@RestController
@RequestMapping("/info/individual")
// Pour chaque controleur, il faut copier le AllArgsConstructor tel quel
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class IndividualController {

    IndividualServiceImpl individualService;

    @PostMapping("/find-all-individual")
    public BaseResVO findAllParticulier() {
        List<Individual> userList = individualService.findAllProfile();
        if (userList != null) {
            return ResultVOUtils.success(userList);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    //le uid est récupéré dans l'url pour le renvoyer au front-end
    @PostMapping("/find-by-id/{uid}")
    public BaseResVO findParticulierById(@PathVariable String uid){
        Profile profile = individualService.findProfileById(uid);
        if(profile != null){
            return ResultVOUtils.success(profile);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/update-individual-info")
    public BaseResVO updateUserInfo(@RequestBody IndividualReqVO individualReqVO) {
        Profile profile = individualService.updateUserInfo(individualReqVO.getIndividual());
        if (profile != null) {
            return ResultVOUtils.success(profile);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }


}
