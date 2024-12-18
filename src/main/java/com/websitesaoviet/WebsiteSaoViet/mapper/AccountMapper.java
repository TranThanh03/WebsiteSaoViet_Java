package com.websitesaoviet.WebsiteSaoViet.mapper;

import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.AccountUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.response.AccountResponse;
import com.websitesaoviet.WebsiteSaoViet.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account toAccount(AccountCreationRequest request);
    AccountResponse toAccountResponse(Account account);
    void updateAccount(@MappingTarget Account account, AccountUpdateRequest request);
}
