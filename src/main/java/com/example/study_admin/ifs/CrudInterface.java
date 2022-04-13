package com.example.study_admin.ifs;

import com.example.study_admin.model.network.Header;

public interface CrudInterface<Res, Req> {

    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);

}
