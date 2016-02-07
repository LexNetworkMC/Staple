/*
 * This file is part of Staple, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016, Lexteam <http://www.lexteam.xyz/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package xyz.lexteam.minecraft.staple.service;

import com.google.common.collect.Sets;
import org.spongepowered.api.service.context.ContextCalculator;
import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.service.economy.EconomyService;
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.service.economy.account.UniqueAccount;
import org.spongepowered.api.service.economy.account.VirtualAccount;
import xyz.lexteam.minecraft.staple.data.Configuration;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class StapleEconomyService implements EconomyService {

    private final Configuration configuration;
    private Currency defaultCurrency;
    private Set<Currency> currencies = Sets.newHashSet();

    public StapleEconomyService(Configuration configuration) {
        this.configuration = configuration;

        for (Configuration.Currency currency : configuration.getCurrencies()) {
            StapleCurrency stapleCurrency = new StapleCurrency(currency);
            this.currencies.add(stapleCurrency);
            if (currency.isDefault()) {
                this.defaultCurrency = stapleCurrency;
            }
        }
    }

    @Override
    public Currency getDefaultCurrency() {
        return this.defaultCurrency;
    }

    @Override
    public Set<Currency> getCurrencies() {
        return this.currencies;
    }

    @Override
    public Optional<UniqueAccount> getAccount(UUID uuid) {
        return null;
    }

    @Override
    public Optional<Account> getAccount(String identifier) {
        return null;
    }

    @Override
    public Optional<UniqueAccount> createAccount(UUID uuid) {
        return null;
    }

    @Override
    public Optional<VirtualAccount> createVirtualAccount(String identifier) {
        return null;
    }

    @Override
    public void registerContextCalculator(ContextCalculator<Account> calculator) {

    }
}
