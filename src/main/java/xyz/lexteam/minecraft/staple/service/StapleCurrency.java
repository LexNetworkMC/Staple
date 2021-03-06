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

import org.spongepowered.api.service.economy.Currency;
import org.spongepowered.api.text.Text;
import xyz.lexteam.minecraft.staple.data.Configuration;

import java.math.BigDecimal;

public class StapleCurrency implements Currency {

    private final Configuration.Currency currency;

    public StapleCurrency(Configuration.Currency currency) {
        this.currency = currency;
    }

    @Override
    public Text getDisplayName() {
        return Text.of(this.currency.getDisplayName());
    }

    @Override
    public Text getPluralDisplayName() {
        return Text.of(this.currency.getPluralDisplayName());
    }

    @Override
    public Text getSymbol() {
        return Text.of(this.currency.getSymbol());
    }

    @Override
    public Text format(BigDecimal amount, int numFractionDigits) {
        return null;
    }

    @Override
    public int getDefaultFractionDigits() {
        return 2;
    }

    @Override
    public boolean isDefault() {
        return this.currency.isDefault();
    }
}
