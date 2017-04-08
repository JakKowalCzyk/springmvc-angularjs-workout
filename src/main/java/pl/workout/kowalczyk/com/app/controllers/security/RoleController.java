package pl.workout.kowalczyk.com.app.controllers.security;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.workout.kowalczyk.com.app.controllers.ModelController;
import pl.workout.kowalczyk.com.app.model.DTO.security.RoleDTO;

import java.util.List;

/**
 * Created by JK on 2017-04-08.
 */
@Api(tags = "Role API", description = "Services for Roles")
@RequestMapping("/role")
public interface RoleController extends ModelController<RoleDTO> {

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    RoleDTO getObject(@PathVariable Long id);

    @Override
    @RequestMapping(method = RequestMethod.PUT)
    RoleDTO updateObject(@RequestBody RoleDTO model);

    @Override
    @RequestMapping(method = RequestMethod.POST)
    RoleDTO addObject(@RequestBody RoleDTO model);

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<RoleDTO> findAll();

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteObject(@PathVariable Long id);
}
