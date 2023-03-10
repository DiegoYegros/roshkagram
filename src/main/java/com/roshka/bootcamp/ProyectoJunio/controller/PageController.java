package com.roshka.bootcamp.ProyectoJunio.controller;
import com.roshka.bootcamp.ProyectoJunio.model.Album;
import com.roshka.bootcamp.ProyectoJunio.model.Categoria;
import com.roshka.bootcamp.ProyectoJunio.service.AlbumService;
import com.roshka.bootcamp.ProyectoJunio.service.CategoriaService;
import com.roshka.bootcamp.ProyectoJunio.service.IAlbumService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;


@Controller
public class PageController {
    @Autowired
    private IAlbumService albumService;
    @Autowired
    private AlbumService albumService2;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/albumes")
    public String getPaginatedAlbums (@RequestParam(name="pageNo", required=false,defaultValue= "0") int pageNo,
             @RequestParam(name="categ", required=false ,defaultValue= "0") long categ ,Model model) {
        int pageSize = 6;
        Page<Album> albumes;
        String pages[];
        List<Album> auxiliar = albumService2.list();
        int size = (int) Math.ceil((auxiliar.size())/((double)(pageSize)));
        if(pageNo > size || pageNo < 0)
            pageNo = 0;

        if (categ == 0)
            albumes = albumService.findPaginated(pageNo, pageSize);
        else
            albumes = albumService.findPaginatedFilter(pageNo, pageSize, categoriaService.findById(categ));

        size = (int) Math.ceil((albumes.getTotalElements())/((double)(pageSize)));
        pages = albumService.findPages(size);
        List<Categoria> categorias = categoriaService.list();
        Optional<Categoria> cat = categoriaService.findById(categ);


        int prev = (pageNo - 1);
        int next = (pageNo + 1);
        if(prev < 0)
            prev = 0;
        if(next > pages.length - 1)
            next = pages.length - 1;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        auth.getName();


        model.addAttribute("albumLista", albumes);
        model.addAttribute("categorias", categorias);
        model.addAttribute("pages",pages);
        model.addAttribute("pageNo",pageNo);

        if(cat.isPresent())
            model.addAttribute("categName", cat.get().getNombre());
        else
            model.addAttribute("categName","Categoria");

        model.addAttribute("categ",categ);
        model.addAttribute("prev",prev);
        model.addAttribute("next",next);

        return "albumes";
    }
}
