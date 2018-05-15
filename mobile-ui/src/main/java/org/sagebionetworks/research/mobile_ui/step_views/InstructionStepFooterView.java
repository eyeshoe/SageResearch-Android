/*
 * BSD 3-Clause License
 *
 * Copyright 2018  Sage Bionetworks. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1.  Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * 2.  Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * 3.  Neither the name of the copyright holder(s) nor the names of any contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission. No license is granted to the trademarks of
 * the copyright holders even if such marks are included in this software.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.sagebionetworks.research.mobile_ui.step_views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import org.sagebionetworks.research.domain.mobile_ui.R;

public class InstructionStepFooterView extends ConstraintLayout{
    private Button nextButton;
    private Button backButton;
    private Button reminderButton;
    private View shadowView;
    private boolean isBackHidden;
    private boolean isReminderHidden;
    private boolean isShadowHidden;

    public InstructionStepFooterView(final Context context) {
        super(context);
    }

    public InstructionStepFooterView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        this.commonInit(attrs, 0, 0);
    }

    public InstructionStepFooterView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.commonInit(attrs, defStyleAttr, 0);
    }

    private void commonInit(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.inflate(this.getContext(), R.layout.mpower2_instruction_step_footer, this);

        TypedArray a = this.getContext().obtainStyledAttributes(attrs, R.styleable.InstructionStepFooterView,
                defStyleAttr, defStyleRes);
        this.isBackHidden = a.getBoolean(R.styleable.InstructionStepFooterView_isBackHidden, false);
        this.isReminderHidden = a.getBoolean(R.styleable.InstructionStepFooterView_isReminderHidden, false);
        this.isShadowHidden = a.getBoolean(R.styleable.InstructionStepFooterView_isShadowHidden, false);
        a.recycle();
        ConstraintLayout root = this.findViewById(R.id.layout);
        this.nextButton = (Button) root.getViewById(R.id.footer_action_forward);
        this.backButton = (Button) root.getViewById(R.id.footer_action_backward);
        this.reminderButton = (Button) root.getViewById(R.id.footer_action_reminder);
        this.shadowView = (View) root.getViewById(R.id.footer_shadow);
        // Get the attributes
        if (this.isBackHidden) {
            this.backButton.setVisibility(View.GONE);
        }

        if (this.isReminderHidden) {
            this.reminderButton.setVisibility(View.GONE);
        }

        if (this.isShadowHidden) {
            this.shadowView.setVisibility(View.GONE);
        }
    }
}
