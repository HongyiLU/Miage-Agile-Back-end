package com.projectagile.webprojectagile.controller;

import com.projectagile.webprojectagile.entity.Contact;
import com.projectagile.webprojectagile.enums.ResultEnum;
import com.projectagile.webprojectagile.service.ContactService;
import com.projectagile.webprojectagile.service.EnterpriseService;
import com.projectagile.webprojectagile.service.impl.EnterpriseServiceImpl;
import com.projectagile.webprojectagile.utils.ResultVOUtils;
import com.projectagile.webprojectagile.vo.req.ContactReqVO;
import com.projectagile.webprojectagile.vo.res.BaseResVO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user/enterprise/contact")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContactController {

    ContactService contactService;

    EnterpriseServiceImpl enterpriseService;

    @PostMapping("/update-contact")
    public BaseResVO updateContact (@Valid @RequestBody ContactReqVO addContactReqVO){
        addContactReqVO.getContacts().forEach(contact -> {
            enterpriseService.findByIdEnterprise(contact.getUid());
        });
        List<Contact> contacts = contactService.updateContact(addContactReqVO.getContacts());

        if(contacts != null){
            return ResultVOUtils.success(contacts);
        } else {
            return ResultVOUtils.error(ResultEnum.PARAM_VERIFY_FALL);
        }
    }

    @PostMapping("/find-all-contact/{uid}")
    public BaseResVO findAllContact(@PathVariable String uid){
        enterpriseService.findByIdEnterprise(uid);
        return ResultVOUtils.success(contactService.getAllContact(uid));

    }

    @PostMapping("/delete-contact/{id}")
    public BaseResVO deleteContactById(@PathVariable int id){
        contactService.deleteContact(id);
        return ResultVOUtils.success(null);
    }

    @PostMapping("/delete-all-contact/{uid}")
    public BaseResVO deleteAllContact(@PathVariable String uid){
        enterpriseService.findByIdEnterprise(uid);
        contactService.deleteAllContact(uid);
        return ResultVOUtils.success(null);
    }
}
